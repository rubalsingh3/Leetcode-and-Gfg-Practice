class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length+1];
        return solve(nums, 0, -1, dp);
    }
    public int solve(int[] nums, int i, int prev, int[][] dp){
        if(i == nums.length) return 0;

        // dp check
        if(prev != -1 && dp[i][prev] != 0) return dp[i][prev];
        // take condition
        int take = 0;
        if(prev == -1 || nums[prev] < nums[i]){
            take = 1 + solve(nums, i+1, i, dp);
        }
        // skip condition
        int skip = solve(nums, i+1, prev, dp);
        
        if(prev != -1){
            dp[i][prev] = Math.max(take, skip);
        } 
        return Math.max(take, skip);
    }
}