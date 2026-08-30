class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);

        int ans = solve(coins, amount, dp);
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    public int solve(int[] coins, int amount, int[] dp) {
        if (amount == 0) return 0;
        
        if (dp[amount] != -1) return dp[amount];

        int ans = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount - coin >= 0) {
                int sub = solve(coins, amount - coin, dp);
                if (sub != Integer.MAX_VALUE) {
                    ans = Math.min(ans, sub+1);
                }

            }

        }
        return dp[amount] = ans;
    }
}