package interview.pinterest.DecodeWays;

class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0)
            return 0;

        int n = s.length();
        int[] dp = new int[n];
        if(s.charAt(0) != '0')
            dp[0] = 1;
        if(s.length() == 1)
            return dp[0];

        if(s.charAt(0) != '0' && Integer.parseInt(s.substring(0, 2)) <= 26)
            dp[1]++;
        if(s.charAt(1) != '0')
            dp[1] += dp[0];

        for(int i = 2; i < n; i++) {
            if(s.charAt(i) != '0') {
                dp[i] += dp[i - 1];
            }
            if(s.charAt(i - 1) != '0' && Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n - 1];
    }
}