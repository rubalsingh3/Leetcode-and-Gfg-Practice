class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] res = new int[mat.length][2];
        int[] ans = new int[k];
        for(int i=0; i<mat.length; i++){
            int count = 0;
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j] == 1) count++;

            }
            res[i][0] = count;
            res[i][1] = i;
        }
        Arrays.sort(res, (a,b) -> Integer.compare(a[0], b[0]));
        for(int i=0; i<k; i++){
            ans[i] = res[i][1];
        }
        return ans;
    }
}