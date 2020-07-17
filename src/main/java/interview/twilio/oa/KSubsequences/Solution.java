package interview.twilio.KSubsequences;

public class Solution {
    public static int getNumOfKSubsequences(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum[i] += sum[i - 1] + nums[i];
        }

        int[] count = new int[k];
        int res = 0;

        for(int s: sum) {
            if (s % k == 0)
                res++;
            count[((s % k) + k) % k]++;
        }

        for(int n: count)
            res += n * (n - 1) / 2;

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Solution.getNumOfKSubsequences(new int[] {5, 10, 11, 9, 5}, 5));
    }
}
