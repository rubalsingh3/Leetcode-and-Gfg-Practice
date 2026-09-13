class Solution {
    public int maxSumDivThree(int[] nums) {
        int[][] dp = new int[nums.length][3];
        for(int[] rows: dp) Arrays.fill(rows, -1);
        return solve(0, 0, nums, dp);
    }
    public int solve(int i, int rem, int[] nums, int[][] dp){
        if(i >= nums.length){
            if(rem == 0) return 0;
            return Integer.MIN_VALUE;
        }
        if(dp[i][rem] != -1) return dp[i][rem];
        int temp = (rem + nums[i]) % 3;
        int take = nums[i] + solve(i+1, temp, nums, dp);
        int skip = solve(i+1, rem, nums, dp);
        return dp[i][rem] = Math.max(take, skip);
    }
}