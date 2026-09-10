class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int[] rows : dp) Arrays.fill(rows, -1);
        return solve(0, 0, obstacleGrid, m, n, dp);
    }
    public int solve(int i, int j, int[][] grid, int m, int n, int[][] dp){
        if(i >= m || i < 0 || j >= n || j < 0 || grid[i][j] == 1){
            return 0;
        }
        if(i == m-1 && j == n-1){
            return 1;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int down = solve(i+1, j, grid, m, n, dp);
        int right = solve(i, j+1, grid, m, n, dp);
        return dp[i][j] = down + right;
    }
}