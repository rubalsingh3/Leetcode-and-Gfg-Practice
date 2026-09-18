class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length][m+1][n+1];

        // fill 3D dp
        for(int i=0; i<strs.length; i++){
            for(int j=0; j<=m; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(strs, 0, m, n, dp);
    }

    public int solve(String[] strs, int i, int m, int n, int[][][] dp){
        if(i >= strs.length) return 0;

        if(dp[i][m][n] != -1) return dp[i][m][n];

        int zeroes = 0;
        int ones = 0;

        for(char c : strs[i].toCharArray()){
            if(c == '0') zeroes++;
            else ones++;
        }

        // take condition
        int take = 0;
        if(zeroes <= m && ones <= n){
            take = 1 + solve(strs, i+1, m - zeroes, n - ones, dp);
        }        

        // skip condition
        int skip = solve(strs, i+1, m, n, dp);

        return dp[i][m][n] = Math.max(take, skip);

    }
}