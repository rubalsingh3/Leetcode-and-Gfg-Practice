class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        for(int len = 1; len <= n; len++){
            for(int i = 0; i <= n-len; i++){
                int j = i + len - 1;
                for(int k = i; k <= j; k++){
                    // left and right are initially 1 
                    // if any value exists if replaces left and right
                    int left = 1;
                    int right = 1;

                    if(i != 0) left = nums[i-1];
                    if(j != n-1) right = nums[j+1];

                    // before and after are initially 0
                    // to avoid accessing out of bound index
                    int before = 0;
                    int after = 0;

                    if(i != k) before = dp[i][k-1];
                    if(j != k) after = dp[k+1][j];

                    dp[i][j] = Math.max(before + after + left * nums[k] * right, dp[i][j]);
                }
            }
        }
        return dp[0][n-1];
    }
}