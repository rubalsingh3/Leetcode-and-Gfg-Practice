class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length()+1][p.length()+1];
    
        return solve(s, p, s.length(), p.length(), dp);
    
    }
    public boolean solve(String str, String pat, int i, int j, Boolean[][] dp){
        // if both the strings are empty 
        if(i == 0 && j == 0) return true;
        // if pat is empty
        if(j == 0) return false;

        // dp check
        if(dp[i][j] != null) return dp[i][j];

        // if str is empty pat can only have '*'
        if(i == 0){
            return dp[i][j] = pat.charAt(j-1) == '*' && solve(str, pat, i, j-1, dp);
        }

        // pat == '*'
        if(pat.charAt(j-1) == '*'){
            return dp[i][j] = solve(str, pat, i-1, j, dp) || solve(str, pat, i, j-1, dp);
        }
        // pat == '?' or both chars equal 
        if(pat.charAt(j-1) == '?' || str.charAt(i-1) == pat.charAt(j-1)){
            return dp[i][j] = solve(str, pat, i-1, j-1, dp);
        }   

        // no match
        return dp[i][j] = false;
    }
}