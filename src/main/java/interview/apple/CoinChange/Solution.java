package interview.apple.CoinChange;

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0)
            return 0;
        if(coins == null || coins.length == 0)
            return -1;

        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for(int i = 1; i <= amount; i++)
            dp[i] = -1;
        for(int i = 0; i < coins.length; i++) {
            if(coins[i] <= amount){
                dp[coins[i]] = 1;
            }
        }

        for(int i = 1; i <= amount; i++) {
            for(int c: coins) {

                if(i - c >= 0) {
                    if(dp[i - c] == -1)
                        continue;

                    if(dp[i] == -1){
                        dp[i] = dp[i - c] + 1;
                    } else {
                        dp[i] = Math.min(dp[i], dp[i - c] + 1);
                    }
                }
            }
        }

        return dp[amount] == 0 ? - 1: dp[amount];
    }
}
