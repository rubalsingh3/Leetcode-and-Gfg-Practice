class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] x : dp) Arrays.fill(x, -1);

        return solve(word1, word2, 0, 0, dp);
    }
    public int solve(String s1, String s2, int i, int j, int[][] dp){
        // if s1 finishes -> insert remaining characters of s2
        if(i == s1.length()) return s2.length() - j;

        // if s2 finishes -> delete rem char of s1
        if(j == s2.length()) return s1.length() - i;

        // dp check
        if(dp[i][j] != -1) return dp[i][j];

        // if characters match
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = solve(s1, s2, i+1, j+1, dp);
        }   

        int insert = 1 + solve(s1, s2, i+1, j, dp);
        int delete = 1 + solve(s1, s2, i, j+1, dp);
        int replace = 1 + solve(s1, s2, i+1, j+1, dp);

        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }
}