class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] x : dp) Arrays.fill(x, -1);
        
        return solve(amount, coins.length-1, coins, dp);
    }
    public int solve(int amount,int idx, int[] coins, int[][] dp){
        if(idx == 0){
            return (amount % coins[idx] == 0) ? 1 : 0;
        }
        if(dp[idx][amount] != -1) return dp[idx][amount];
        int notTake = solve(amount, idx-1, coins, dp);
        int take = 0;
        if(coins[idx] <= amount){
            take = solve(amount - coins[idx], idx, coins, dp);
        }
        return dp[idx][amount] = notTake + take;
    }
}