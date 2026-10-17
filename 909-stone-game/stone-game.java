class Solution {
    public boolean stoneGame(int[] piles) {
        int total = 0;
        for(int stones : piles){
            total += stones;
        }
        
        int n = piles.length;
        int[][] dp = new int[n][n];
        for(int[] row : dp) Arrays.fill(row, -1);

        int alice = solve(piles, 0, n-1, dp);

        return alice > (total - alice) ? true : false;
    }
    public int solve(int[] piles, int i, int j, int[][] dp){
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int takeFirst = piles[i] + Math.min(solve(piles, i+2, j, dp), solve(piles, i+1, j-1, dp));

        int takeLast = piles[j] + Math.min(solve(piles, i+1, j-1, dp), solve(piles, i, j-2, dp));

        return dp[i][j] = Math.max(takeFirst, takeLast);
    }
}