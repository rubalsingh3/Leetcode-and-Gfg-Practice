class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        for(int[] row : vis) Arrays.fill(row, -1);

        int count = 0;

        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(grid[row][col] == '1' && vis[row][col] == -1){
                    bfs(grid, row, col, vis);
                    count++;
                }
            }
        } 
        return count;
    }
    public void bfs(char[][] grid, int i, int j, int[][] vis){
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        vis[i][j] = 1;

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        while(!q.isEmpty()){
            int[] curr = q.poll();

            int x = curr[0];
            int y = curr[1];

            
            for(int k = 0; k < 4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == '1' && vis[nx][ny] == -1){
                    vis[nx][ny] = 1;
                    q.add(new int[]{nx, ny});
                }
            }

        }
    }

}