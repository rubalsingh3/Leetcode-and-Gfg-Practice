class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int maxArea = 0;
        boolean[][] vis = new boolean[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea, bfs(grid, i, j, vis));
                }
            }
        }
        return maxArea;
    }

    public int bfs(int[][] grid, int i, int j, boolean[][] vis){
        int n = grid.length;
        int m = grid[0].length;

        int res = 0;
        
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{i, j});
        vis[i][j] = true;

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        while(!q.isEmpty()){
            int[] curr = q.poll();

            int x = curr[0];
            int y = curr[1];
            
            res++;
            
            for(int k = 0; k < 4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1 && 
                vis[nx][ny] == false){
                    vis[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return res;
    }
}