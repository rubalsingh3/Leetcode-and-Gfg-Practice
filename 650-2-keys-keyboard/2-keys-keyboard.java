class Solution {
    public int minSteps(int n) {
        if(n == 1) return 0;
        int[][] dp = new int[1001][1001];
        for(int[] rows : dp){
            Arrays.fill(rows, -1);
        }
        return 1 + solve(n, 1, 1, dp);
    }
    public int solve(int n, int clip, int curr, int[][] dp){
        if(curr == n) return 0;
        if(curr > n) return 100000;
        if(dp[curr][clip] != -1) return dp[curr][clip];

        int copyPaste = 2 + solve(n, curr, curr + curr, dp);
        int paste = 1 + solve(n, clip, curr + clip, dp);
        return dp[curr][clip] = Math.min(copyPaste, paste);
    }
}