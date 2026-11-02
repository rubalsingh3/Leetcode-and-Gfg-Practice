class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;

        int[][] dp = new int[matrix.length][matrix.length];
        for(int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);

        for(int i = 0; i < matrix.length; i++){
            ans = Math.min(ans, solve(matrix, 0, i, dp));
        }
        return ans;
    }
    public int solve(int[][] matrix, int row, int col, int[][] dp){
        if(col < 0 || col >= matrix.length) return Integer.MAX_VALUE;
        if(row == matrix.length-1) return matrix[row][col];

        if(dp[row][col] != Integer.MAX_VALUE) return dp[row][col];

        int below = solve(matrix, row + 1, col, dp);
        int left = solve(matrix, row + 1, col - 1, dp);
        int right = solve(matrix, row + 1, col + 1, dp);

        return dp[row][col] = matrix[row][col] +  Math.min(below, Math.min(left, right));
    }
}