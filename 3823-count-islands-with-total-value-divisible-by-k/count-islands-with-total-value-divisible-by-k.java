class Solution {
    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int res = 0;

        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(grid[row][col] != 0){
                    if(dfs(grid, row, col) % k == 0){
                        res++;
                    }
                }
            }
        }
        return res;
    }
    public long dfs(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return 0;
        if(grid[i][j] == 0) return 0;
        
        int t = grid[i][j];
        grid[i][j] = 0;

        return t + dfs(grid, i+1, j) +
                            dfs(grid, i-1, j) +
                            dfs(grid, i, j+1) +
                            dfs(grid, i, j-1);
    }
}