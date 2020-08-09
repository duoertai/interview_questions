package interview.pinterest.phone.SearchInRotatedSortedArray;

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;

        int left = 0;
        int right = nums.length - 1;

        while(left < right - 1) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return mid;

            if(nums[left] < nums[mid]) {
                if(nums[mid] <= target) {
                    left = mid;
                } else {
                    if(nums[left] <= target) {
                        right = mid;
                    } else {
                        left = mid;
                    }
                }
            } else {
                if(nums[mid] >= target) {
                    right = mid;
                } else {
                    if(target <= nums[right]) {
                        left = mid;
                    } else {
                        right = mid;
                    }
                }
            }
        }

        if(nums[left] == target)
            return left;
        if(nums[right] == target)
            return right;

        return -1;
    }
}
