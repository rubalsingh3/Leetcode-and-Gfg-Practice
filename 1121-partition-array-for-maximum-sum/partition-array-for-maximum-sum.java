class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);

        return solve(arr, 0, k, dp);
    }
    public int solve(int[] arr, int i, int k, int[] dp){
        if(i >= arr.length) return 0;

        if(dp[i] != -1) return dp[i];

        int res = 0;
        int max = -1;

        for(int j = i; j < arr.length && j-i+1 <= k; j++){
            max = Math.max(max, arr[j]);
            res = Math.max(res, ((j-i+1) * max) + solve(arr, j+1, k, dp)); 
        }
        return dp[i] = res;
    }
}