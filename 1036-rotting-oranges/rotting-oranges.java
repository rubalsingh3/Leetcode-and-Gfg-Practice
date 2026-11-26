class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        boolean[][] vis = new boolean[n][m];
        
        int res = 0;
        int fresh = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                    vis[i][j] = true;
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0) return fresh;

        int[] ans = bfs(grid, q, vis, fresh, res);

        return (ans[0] == 0) ? ans[1] : -1;
    }
    public int[] bfs(int[][] grid, Queue<int[]> q, boolean[][] vis, int fresh, int res){
        int n = grid.length;
        int m = grid[0].length;

        int[][] dir = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };

        while(!q.isEmpty() && fresh > 0){
            int size = q.size();

            for(int k = 0; k < size; k++){
                int[] curr = q.poll();

                int r = curr[0];
                int c = curr[1];

                for(int[] d : dir){
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if(nr >= 0 && nr < n && nc >= 0 && nc < m &&
                    grid[nr][nc] == 1 && !vis[nr][nc]){

                        vis[nr][nc] = true;
                        grid[nr][nc] = 2;

                        fresh--;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
            res++;
        }
        return new int[]{fresh, res};
    }
}