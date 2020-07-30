package interview.pinterest.KthLargestElementInAnArray;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return helper(nums, k, 0, nums.length - 1);
    }

    private int helper(int[] nums, int k, int start, int end) {
        int pivot = nums[end];
        int i = start;
        int left = start;
        int right = end;

        while(i <= right) {
            if(nums[i] == pivot) {
                i++;
            } else if(nums[i] < pivot) {
                swap(nums, left++, i++);
            } else {
                swap(nums, i, right--);
            }
        }

        if(k >= left && k <= right)
            return nums[k];
        if(k < left)
            return helper(nums, k, start, left - 1);
        else
            return helper(nums, k, right + 1, end);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}