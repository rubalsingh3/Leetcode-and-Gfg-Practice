class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        int n = s.length();

        Boolean[][] dp = new Boolean[n][n];

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j <= n; j++){
                String sub = s.substring(i, j);

                if(solve(s, i, j-1, dp)) res++;
            }
        }

        return res;
    }
    public boolean solve(String s, int i, int j, Boolean[][] dp){
        if(i >= j) return true;

        if(dp[i][j] != null) return dp[i][j];

        if(s.charAt(i) != s.charAt(j)){
            return dp[i][j] = false;
        }

        return dp[i][j] = solve(s, i+1, j-1, dp);
    }
}