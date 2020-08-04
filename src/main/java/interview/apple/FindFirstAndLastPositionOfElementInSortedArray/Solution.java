package interview.apple.FindFirstAndLastPositionOfElementInSortedArray;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int[]{-1, -1};

        int[] res = new int[2];
        int left1 = 0;
        int right1 = nums.length - 1;

        while(left1 < right1 - 1) {
            int mid = left1 + (right1 - left1) / 2;

            if(nums[mid] >= target)
                right1 = mid;
            else
                left1 = mid;
        }

        if(nums[left1] == target)
            res[0] = left1;
        else if(nums[right1] == target)
            res[0] = right1;
        else
            return new int[]{-1, -1};

        int left2 = 0;
        int right2 = nums.length - 1;

        while(left2 < right2 - 1) {
            int mid = left2 + (right2 - left2) / 2;

            if(nums[mid] <= target)
                left2 = mid;
            else
                right2 = mid;
        }

        if(nums[right2] == target)
            res[1] = right2;
        else if(nums[left2] == target)
            res[1] = left2;
        else
            return new int[]{-1, -1};

        return res;
    }
}