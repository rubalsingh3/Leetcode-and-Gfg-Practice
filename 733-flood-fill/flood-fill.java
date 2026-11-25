class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // int n = image.length;
        // int m = image[0].length;

        // int[][] vis = new int[n][m];
        // for(int[] row : vis) Arrays.fill(row, -1);

        // int original = image[sr][sc];

        return bfs(image, sr, sc, color);

    }
    public int[][] bfs(int[][] image, int i, int j, int color){
        int n = image.length;
        int m = image[0].length;
        
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{i, j});
        int strt = image[i][j];
        image[i][j] = color;

        if(strt == color ) return image;
        // vis[i][j] = 1;

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        while(!q.isEmpty()){
            int[] curr = q.poll();

            int x = curr[0];
            int y = curr[1];

            
            for(int k = 0; k < 4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m && image[nx][ny] == strt){
                    // vis[nx][ny] = 1;
                    image[nx][ny] = color;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return image;
    }
}