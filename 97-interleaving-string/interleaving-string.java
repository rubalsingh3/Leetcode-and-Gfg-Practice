class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int k = s3.length();
        Boolean[][] dp = new Boolean[n+1][m+1];
        return solve(s1, s2, s3, n, m, k, dp);
    }

    public boolean solve(String s1, String s2, String s3, int i, int j, int k, Boolean[][] dp) {
        if (i == 0 && j == 0 && k == 0)
            return true;

        if(dp[i][j] != null) return dp[i][j];

        boolean take_s1 = false;
        boolean take_s2 = false;
        if(i > 0 && k > 0 && s1.charAt(i-1) == s3.charAt(k-1)){
            take_s1 = solve(s1, s2, s3, i-1, j, k-1, dp);
        }
        if(j > 0 && k > 0 && s2.charAt(j-1) == s3.charAt(k-1))
            take_s2 = solve(s1, s2, s3, i, j-1, k-1, dp);
        return dp[i][j] = take_s1 || take_s2;
    }
}