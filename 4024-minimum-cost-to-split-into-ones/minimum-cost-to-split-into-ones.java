class Solution {
    public int minCost(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n, dp);
    }
    public int solve(int n, int[] dp){
        if(n == 1) return 0;

        int ans = Integer.MAX_VALUE;

        if(dp[n] != -1) return dp[n];

        for(int a = 1; a < n; a++){
            int b = n - a;

            int cost = a * b + solve(a, dp) + solve(b, dp);
            ans = Math.min(ans, cost);
        }
        return dp[n] = ans;
    }
}