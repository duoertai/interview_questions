package interview.pinterest.phone.MaximumLengthOfRepeatedSubarray;

class Solution {
    public int findLength(int[] A, int[] B) {
        if(A == null || A.length == 0 || B == null || B.length == 0)
            return 0;

        int m = A.length;
        int n = B.length;
        int res = 0;

        int[][] dp = new int[m + 1][n + 1];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(A[i] == B[j])
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                res = Math.max(res, dp[i][j]);
            }
        }

        return res;
    }

    /*
    class Solution {
    public int findLength(int[] A, int[] B) {
        if(A == null || A.length == 0 || B == null || B.length == 0)
            return 0;

        int m = A.length;
        int n = B.length;
        int res = 0;

        int[][] dp = new int[m + 1][n + 1];

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(A[i - 1] == B[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                res = Math.max(res, dp[i][j]);
            }
        }

        return res;
    }
}
     */
}
