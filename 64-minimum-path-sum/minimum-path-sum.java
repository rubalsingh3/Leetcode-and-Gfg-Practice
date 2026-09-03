class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] row : dp) Arrays.fill(row, -1);
        return solve(0, 0, dp, grid);   
    }

    public int solve(int i, int j, int[][] dp, int[][] grid){
        if(i == grid.length-1 && j == grid[0].length-1) return dp[i][j] = grid[i][j];
        if(i >= grid.length || j >= grid[0].length) return Integer.MAX_VALUE;
        if(dp[i][j] != -1) return dp[i][j];

        int down = solve(i+1, j, dp, grid);
        int right = solve(i, j+1, dp, grid);
        return dp[i][j] = grid[i][j] + Math.min(down, right);
    }
}