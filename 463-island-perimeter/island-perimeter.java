class Solution {
    int n;
    int m;
    public int islandPerimeter(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        int res = 0;
        int[][] vis = new int[n][m];
        for(int[] x : vis) Arrays.fill(x, 0);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] != 0){
                    res += dfs(grid, i, j, vis);
                }
            }
        }
        return res;
    }
    public int dfs(int[][] grid, int i, int j, int[][] vis){
        if(i < 0 || i >= n || j < 0 || j >= m) return 1;
        if(grid[i][j] == 0) return 1;

        if(vis[i][j] == 1) return 0;
        
        vis[i][j] = 1;
        return dfs(grid, i+1, j, vis) + 
                dfs(grid, i-1, j, vis) + 
                dfs(grid, i, j+1, vis) +
                dfs(grid, i, j-1, vis);
    }
}