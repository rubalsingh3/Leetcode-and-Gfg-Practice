class Solution {
    int sum;
    public int lastStoneWeightII(int[] stones) {
        sum = 0;
        for(int x : stones){
            sum += x;
        }
        int target = (int) Math.ceil(sum/2);

        int[][] dp = new int[stones.length][target];
        for(int[] x : dp) Arrays.fill(x, -1);
        return solve(0, 0, target, stones, dp);
    }
    
    public int solve(int i, int total, int target, int[] stones, int[][] dp){
        if(i == stones.length || total >= target){
            return Math.abs(total - (sum - total));
        }

        if(dp[i][total] != -1) return dp[i][total];
        int take = solve(i+1, total + stones[i], target, stones, dp);
        int skip = solve(i+1, total, target, stones, dp);

        return dp[i][total] = Math.min(take, skip);
    }
}