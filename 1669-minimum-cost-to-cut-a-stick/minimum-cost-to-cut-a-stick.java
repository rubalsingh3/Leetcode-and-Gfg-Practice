class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        
        int m = cuts.length;
        int[] points = new int[m+2];

        points[0] = 0;
        points[m+1] = n;

        for(int i = 0; i<m; i++){
            points[i+1] = cuts[i];
        }
    
        int[][] dp = new int[m+2][m+2];
        for(int[] row : dp) Arrays.fill(row, -1);

        return solve(points, 0, m+1, dp);
    }
    static int solve(int[] points, int l, int r, int[][] dp){
        if(r - l < 2) return 0;

        if(dp[l][r] != -1) return dp[l][r];

        int res = Integer.MAX_VALUE;

        for(int i = l+1; i < r; i++){
            int cost = (points[r] - points[l]) + solve(points, l, i, dp) + solve(points, i, r, dp);
            res = Math.min(res, cost);
        }
        return dp[l][r] = res;
    }
}