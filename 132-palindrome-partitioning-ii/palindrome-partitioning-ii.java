class Solution {
    public int minCut(String s) {
        int n = s.length();
        Boolean[][] pali = new Boolean[n][n];
        int[][] dp = new int[n][n];
        for(int[] row : dp) Arrays.fill(row, -1);

        for(int i=n-1; i>=0; i--){
            for(int j=i; j<n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j-i <= 2) pali[i][j] = true;
                    else pali[i][j] = pali[i+1][j-1];
                }else {
                    pali[i][j] = false;
                }
            }
        }
        return solve(s, 0, n-1, pali, dp);
        
    }
    public static int solve(String s, int i, int j, Boolean[][] pali, int[][] dp){
        if(i >= j || pali[i][j]) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int cuts = Integer.MAX_VALUE;
        
        for(int k = i; k <= j; k++){
            if(pali[i][k]){
                int temp = 1 + solve(s, k+1, j, pali, dp);
                cuts = Math.min(cuts, temp);
            }
        }
        return dp[i][j] = cuts;
    }
    
}