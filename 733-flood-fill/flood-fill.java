class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] vis = new int[image.length][image[0].length];
        for(int[] x : vis) Arrays.fill(x, 0);

        dfs(image, sr, sc, color, image[sr][sc], vis);
        return image;        
    }
    public void dfs(int[][] grid, int i, int j, int color, int original, int[][] vis){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        if(grid[i][j] != original) return;

        if(vis[i][j] == 1) return;
        
        vis[i][j] = 1;
        grid[i][j] = color;

        dfs(grid, i-1, j, color, original, vis);
        dfs(grid, i+1, j, color, original, vis);
        dfs(grid, i, j-1, color, original, vis);
        dfs(grid, i, j+1, color, original, vis);
    }
}