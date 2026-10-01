class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length()+1][p.length()+1];
        return solve(s, p, dp); 
    }
    public boolean solve(String s, String p, Boolean[][] dp){
        if(p.length() == 0){
            return s.length() == 0; 
        }
        if(dp[s.length()][p.length()] != null) return dp[s.length()][p.length()];
        boolean first_char = (s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));
        if(p.length() > 1 && p.charAt(1) == '*'){
            boolean skip = solve(s, p.substring(2), dp);
            boolean take = first_char && solve(s.substring(1), p, dp);
            return dp[s.length()][p.length()] = skip || take;
        }
        return dp[s.length()][p.length()] = first_char && solve(s.substring(1), p.substring(1), dp);
    }
    
    
}