class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] weight = new int[m];
        for(int i=0; i<m; i++){
            int count = 0;
            for(int j=0; j<n; j++){
                if(mat[i][j] == 1){
                    count++;
                }
            }
            weight[i] = count;
        }
        int index = 0;
        int max = weight[0];
        for(int i=0; i<m; i++){
            if(max < weight[i]){
                max = weight[i];
                index = i;
            }
        }
        int res[] = new int[2];
        res[0] = index;
        res[1] = max;
        return res;
    }
}