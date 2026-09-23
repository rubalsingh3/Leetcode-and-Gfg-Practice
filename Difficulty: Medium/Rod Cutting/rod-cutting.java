class Solution {
    public int cutRod(int[] price) {
        int n = price.length;
        
        int[][] dp = new int[n+1][n+1];
        for(int[] x : dp) Arrays.fill(x, -1);
        return solve(n, n, price, dp);
    }
    public int solve(int i, int length, int[] price, int[][] dp){
        if(length == 0) return 0;
        if(i == 0) return 0;
        
        if(dp[i][length] != -1) return dp[i][length];
        
        int skip = solve(i-1, length, price, dp);
        int take = Integer.MIN_VALUE;
        if(length >= i){
            take = price[i-1] + solve(i, length - i, price, dp);    
        }
        
        
        return dp[i][length] = Math.max(take, skip);
    }
}