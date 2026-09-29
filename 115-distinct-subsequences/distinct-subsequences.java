class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n+1][m+1];
        for(int[] rows : dp) Arrays.fill(rows, -1); 
        return solve(s, t, n, m, dp);
    }
    public int solve(String s, String t, int n, int m, int[][] dp){
        // empty t can always be formed
        if(m == 0) return 1;
        // empty s cannot form a non-empty t
        if(n == 0) return 0;
        // dp check
        if(dp[n][m] != -1) return dp[n][m];

        if(s.charAt(n-1) == t.charAt(m-1)){
            return dp[n][m] = solve(s, t, n-1, m-1, dp) + solve(s, t, n-1, m, dp);
        }
        return dp[n][m] = solve(s, t, n-1, m, dp);
    }
}