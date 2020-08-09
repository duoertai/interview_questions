package interview.pinterest.phone.FindPeakElement;

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        if(nums.length == 1)
            return 0;

        int left = 0;
        int right = nums.length - 1;

        while(left < right - 1) {
            int mid = left + (right - left) / 2;

            if(isPeak(nums, mid))
                return mid;

            if(nums[mid] < nums[mid + 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if(isPeak(nums, left))
            return left;
        if(isPeak(nums, right))
            return right;

        return -1;
    }

    private boolean isPeak(int[] nums, int i) {
        if(i == 0)
            return nums[i] > nums[i + 1];
        if(i == nums.length - 1)
            return nums[i - 1] < nums[i];

        return nums[i] > nums[i + 1] && nums[i] > nums[i - 1];
    }
}
