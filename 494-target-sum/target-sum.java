class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, 0, 0, target);
    }
    public int solve(int[] nums, int n, int sum, int target){
        if(n == nums.length){
            if(sum == target) return 1;
            else return 0;
        }
        int x = solve(nums, n+1, sum + nums[n], target);
        int y = solve(nums, n+1, sum - nums[n], target);
        return x+y;
    }
}