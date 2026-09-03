class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] row : dp) Arrays.fill(row, -1);
        return solve(grid.length-1, grid[0].length-1, dp, grid);   
    }

    public int solve(int i, int j, int[][] dp, int[][] grid){
        if(i == 0 && j == 0) return dp[i][j] = grid[i][j];
        if(i < 0 || j < 0) return Integer.MAX_VALUE;
        if(dp[i][j] != -1) return dp[i][j];

        int up = solve(i-1, j, dp, grid);
        int left = solve(i, j-1, dp, grid);
        return dp[i][j] = grid[i][j] + Math.min(up, left);
    }
}