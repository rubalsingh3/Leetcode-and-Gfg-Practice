class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int ans = Integer.MAX_VALUE;

        int[][] dp = new int[n][n];
        for(int row[] : dp) {
            Arrays.fill(row, -1);
        }
        for(int i=0; i<n; i++){
            ans = Math.min(ans, solve(n-1, i, grid, dp));
        }
        return ans;
    }
    public int solve(int i, int j, int[][] grid, int[][] dp){
        if(i == 0) return grid[i][j];
        if(dp[i][j] != -1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int col=0; col<grid.length; col++){
            if(col != j){
                min = Math.min(min, solve(i-1, col, grid, dp));
            }
        }
        return dp[i][j] = grid[i][j] + min;
    }
}