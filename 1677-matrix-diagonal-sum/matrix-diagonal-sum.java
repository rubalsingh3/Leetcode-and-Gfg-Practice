class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;
        int m = mat[0].length;
        for(int i=0; i<n; i++){
            sum += mat[i][i];
            sum += mat[i][m-1-i];
        }
        if(n%2 !=0) sum -= mat[n/2][n/2];
        return sum;
    }
}