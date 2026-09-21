class Solution {
    int sum;
    public int minDifference(int arr[]) {
        sum = 0;
        for(int i : arr) sum += i;
        
        int target = (int)Math.ceil(sum/2);
        
        int[][] dp = new int[arr.length][target];
        for(int[] x : dp) Arrays.fill(x, -1);
        
        return solve(0, 0, target, arr, dp);
    }
    
    public int solve(int i, int total, int target, int[] arr, int[][] dp){
        if(total >= target || i == arr.length) return Math.abs(total - (sum - total));
        if(dp[i][total] != -1) return dp[i][total];
        
        int take = solve(i+1, total + arr[i], target, arr, dp);
        int skip = solve(i+1, total, target, arr, dp);
        
        return dp[i][total] = Math.min(take, skip);
    }
}
