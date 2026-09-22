class Solution {
    public int change(int amount, int[] coins) {
        
        // 2D dp tabulation
        
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        for(int i=0; i<=n; i++){
            dp[i][0] = 1;
        }         
        // fill table
        for(int i = n-1; i >= 0; i--){
            for(int curr = 1; curr <= amount; curr++){
                // skip
                dp[i][curr] = dp[i+1][curr];

                // take
                if(coins[i] <= curr){
                    dp[i][curr] += dp[i][curr - coins[i]];
                }
            }
        }
        return dp[0][amount];
    }
}