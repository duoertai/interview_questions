package interview.apple.SearchInRotatedSortedArray;

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
                if(target > nums[mid]) {
                    left = mid;
                } else {
                    if(target >= nums[left])
                        right = mid;
                    else
                        left = mid;
                }
            } else {
                if(target < nums[mid]) {
                    right = mid;
                } else {
                    if(target <= nums[right])
                        left = mid;
                    else
                        right = mid;
                }
            }
        }

        if(nums[left] == target)
            return left;
        else if(nums[right] == target)
            return right;
        else
            return -1;
    }
}