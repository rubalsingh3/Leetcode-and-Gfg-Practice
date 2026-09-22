class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);

        dp[0] = 0;
        for(int curr = 1; curr <= amount; curr++){
            for(int coin : coins){
                if( curr >= coin){
                    dp[curr] = Math.min(dp[curr], dp[curr - coin] +1);
                }
            }
        }
        return dp[amount] == amount +1 ? -1 : dp[amount];
    }
}