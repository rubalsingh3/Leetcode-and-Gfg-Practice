class Solution {
    public int maximumWealth(int[][] accounts) {
        int res[] = new int[accounts.length];
        int max = 0;
        for(int i=0; i<accounts.length; i++){
            int sum = 0;

            for(int j=0; j<accounts[0].length; j++){
                sum += accounts[i][j];
            }
            res[i] = sum;
        }
        for(int i=0; i<res.length; i++){
            if(res[i] > max) max = res[i];
        }
        return max;
    }
}