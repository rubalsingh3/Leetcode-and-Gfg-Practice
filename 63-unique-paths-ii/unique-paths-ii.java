class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m+1][n+1];

        // filling 1st row
        for(int i = 0; i < n; i++){
            if(i > 0 && grid[0][i-1] == 1 || grid[0][i] == 1){
                dp[0][i] = 0; // 0 ways to reach
                grid[0][i] = 1; // edge case : for filling future dp table 
            } else{
                dp[0][i] = 1;
            }
        }

        // filling 1st col
        for(int j = 0; j < m; j++){
            if(j > 0 && grid[j-1][0] == 1 || grid[j][0] == 1){
                dp[j][0] = 0; // 0 ways to reach
                grid[j][0] = 1; // same edge case 
            } else{
                dp[j][0] = 1;
            }
        }

        // filling remaining table
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(grid[i][j] == 1) dp[i][j] = 0;
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        } 
        return dp[m-1][n-1];
    
    }

}