class Solution {
    static boolean isSubsetSum(int arr[], int sum) {
        Boolean dp[][] = new Boolean[arr.length+1][10001];
        for(Boolean[] row : dp) Arrays.fill(row, null);
        return solve(0, 0, arr, sum, dp);
    }
    
    public static boolean solve(int i, int sum, int arr[], int target, Boolean[][] dp) {
        if(sum == target) return true;
        if(i >= arr.length) return false;
        
        if(dp[i][sum] != null) return dp[i][sum];
        
        Boolean take = false;
        if(sum + arr[i] <= target) take = solve(i+1, sum + arr[i], arr, target, dp);
        Boolean notTake = solve(i+1, sum, arr, target, dp);
        
        return dp[i][sum] = take || notTake;
    }
}