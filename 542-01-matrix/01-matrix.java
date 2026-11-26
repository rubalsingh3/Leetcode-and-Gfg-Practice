class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] distance = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    q.offer(new int[]{i, j});
                    vis[i][j] = true;
                    distance[i][j] = 0;
                }
                else distance[i][j] = mat[i][j];
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
        return distance;
    }
}