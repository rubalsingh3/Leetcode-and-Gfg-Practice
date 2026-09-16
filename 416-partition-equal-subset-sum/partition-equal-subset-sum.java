class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int x : nums){
            total += x;
        }
        int x = total / 2;

        Boolean[][] dp = new Boolean[nums.length+1][total+1];
        for(Boolean[] row : dp) Arrays.fill(row, null);

        if(total % 2 == 0) return solve(nums, 0, x, dp);
        return false; 
    }
    public boolean solve(int[] nums, int i, int x, Boolean[][] dp){
        if(x == 0) return true;
        if(i >= nums.length) return false;

        if(dp[i][x] != null) return dp[i][x];
        
        boolean take = false;
        // nums[i] should be less than x
        if(x >= nums[i]){                
            take = solve(nums, i+1, x-nums[i], dp);
        }
        boolean notTake = solve(nums, i+1, x, dp);
        return dp[i][x] = take || notTake;
    }
}