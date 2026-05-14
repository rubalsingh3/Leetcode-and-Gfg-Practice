class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        return recur(n,dp);
    }
    public int recur(int n, int dp[]){
        if(n == 1 || n == 0) return 1;
        if(n < 0) return 0;
        if(dp[n] != 0) return dp[n];
        dp[n] =  recur(n-1, dp) + recur(n-2, dp);
        return dp[n];
    }
}