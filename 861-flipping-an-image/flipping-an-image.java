class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image[0].length;
        for(int i=0; i<image.length; i++){
            for(int j=0; j<n/2; j++){
                int t = image[i][j];
                image[i][j] = image[i][n-1-j];
                image[i][n-1-j] = t;
            }
        }
        for(int i=0; i<image.length; i++){
            for(int j=0; j<image[0].length; j++){
                if(image[i][j] == 0) image[i][j] = 1;
                else{ image[i][j] = 0;}
            }
        }
        return image;
    }
}