class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] distance = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        int land = 0;
        int water = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    q.offer(new int[]{i, j});
                    vis[i][j] = true;
                    distance[i][j] = 0;
                    land++;
                }else if(grid[i][j] == 0){
                    water++;
                }
            }
        }

        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];

            for(int[] d : dir){
                int nr = row + d[0];
                int nc = col + d[1];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc]){
                    vis[nr][nc] = true;
                    distance[nr][nc] = distance[row][col] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        int max = distance[0][0];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                max = Math.max(max, distance[i][j]);
            }
        }
        return (land == 0 || water == 0) ? -1 : max;
    }
}