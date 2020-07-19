package interview.twilio.phone.LongestContinuousIncreasingSubsequence;

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        int len = 1;
        int max = 1;
        int i = 1;

        while(i < nums.length) {
            if(nums[i] > nums[i - 1]) {
                len++;
                i++;
                max = Math.max(max, len);
            } else {
                len = 1;
                i++;
            }
        }

        return max;
    }
}