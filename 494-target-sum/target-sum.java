class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for(int i : nums){
            total += i;
        }

        int[][] dp = new int[nums.length][2*total +1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        return solve(nums, 0, 0, target, dp, total);
    }
    public int solve(int[] nums, int n, int sum, int target, int[][] dp, int total){
        if(n == nums.length){
            if(sum == target) return 1;
            else return 0;
        }
        if(dp[n][sum + total] != -1) return dp[n][sum + total];
        int y = solve(nums, n+1, sum - nums[n], target, dp, total);
        int x = solve(nums, n+1, sum + nums[n], target, dp, total);
        return dp[n][sum + total] = x+y;
    }
}