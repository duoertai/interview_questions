package interview.pinterest.LongestValidParentheses;

class Solution {
    public int longestValidParentheses(String s) {
        if(s.length() < 2)
            return 0;

        int n = s.length();
        int[] dp = new int[n];

        dp[0] = 0;
        if(s.charAt(0) == '(' && s.charAt(1) == ')')
            dp[1] = 2;
        if(s.length() == 2)
            return dp[1];

        int res = dp[1];

        for(int i = 2; i < n; i++) {
            if(s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
                dp[i] = Math.max(dp[i], dp[i - 2] + 2);
            } else if(s.charAt(i) == ')' && s.charAt(i - 1) == ')') {
                if(i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(')
                    if(i - dp[i - 1] - 2 >= 0) {
                        dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                    } else {
                        dp[i] = dp[i - 1] + 2;
                    }
            }

            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
