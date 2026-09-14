class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row+1][query_glass+1];
        for(double[] row : dp) Arrays.fill(row, -1);
        return Math.min(1.0, solve(poured, query_row, query_glass, dp));
    }
    public double solve(int p, int i, int j, double[][] dp){
        if(i < 0 || j < 0 || i < j) return 0.0; // row cannot be less than glass i<j 
        if(i == 0 && j == 0) return p;
        // dp check
        if(dp[i][j] != -1) return dp[i][j];

        double left = (solve(p, i-1, j-1, dp) -1) /2.0;
        double right = (solve(p, i-1, j, dp) -1) /2.0;
        // glass cannot hold negative value
        if(left < 0) left = 0.0;
        if(right < 0) right = 0.0;
        
        // memoize 
        return dp[i][j] = left + right;
    }
}