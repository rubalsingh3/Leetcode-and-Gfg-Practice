class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        for(int[] row : dp) Arrays.fill(row, -1);
        return solve(0, 0, dungeon, dp);  
    }
    public int solve(int i, int j, int[][] arr, int[][] dp){
        // base case for index out of bound 
        if(i >= arr.length || j >= arr[0].length) return Integer.MAX_VALUE;

        // base case for princess cell
        if(i == arr.length-1 && j == arr[0].length-1){
            return Math.max(1, 1 - arr[i][j]);
        }

        // already calculated
        if(dp[i][j] != -1) return dp[i][j];

        // better option down or right
        int down = solve(i+1, j, arr, dp);
        int right = solve(i, j+1, arr, dp);

        int nextHealth = Math.min(down, right);
        int requiredHealth = nextHealth - arr[i][j];

        return dp[i][j] = Math.max(1, requiredHealth);
    }
}