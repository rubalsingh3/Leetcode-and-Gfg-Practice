class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] x : dp) Arrays.fill(x, -1);

        return solve(0, amount, coins, dp);
    }
    public int solve(int index, int amount, int[] coins, int[][] dp){
        if(amount == 0) return 1;
        if(index == coins.length) return 0;
        
        if(dp[index][amount] != -1) return dp[index][amount];

        int ways = 0;
        // take
        if(coins[index] <= amount){
            ways += solve(index, amount - coins[index], coins, dp);
        }
        // skip 
        ways += solve(index + 1, amount, coins, dp);

        return dp[index][amount] = ways;
    }
}