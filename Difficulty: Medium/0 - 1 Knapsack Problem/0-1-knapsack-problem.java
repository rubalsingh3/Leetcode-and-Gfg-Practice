class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        int dp[][] = new int[val.length][W+1];
        for(int[] x : dp) Arrays.fill(x, -1);
        
        return solve(0, W, val, wt, dp);
    }
    
    public int solve(int i, int W, int val[], int wt[], int dp[][]){
        if(i >= val.length) return 0;
        if(dp[i][W] != -1) return dp[i][W];
        
        int take = 0;
        if(W - wt[i] >= 0){
            take = val[i] + solve(i+1, W - wt[i], val, wt, dp);
        }
        int skip = solve(i+1, W, val, wt, dp);
        
        return dp[i][W] = Math.max(take, skip);
    }
}
