class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        return solve(s, wordDict, 0, dp);    
    }
    public boolean solve(String s, List<String> dict, int i, Boolean[] dp){
        // i only increments if "split" matches in "dict"
        if(i == s.length()) return true;

        // dp check
        if(dp[i] != null) return dp[i];
        
        for(int end = i+1; end <= s.length(); end++){
            // trim the matched "string" 
            String split = s.substring(i, end);
        
            if(dict.contains(split) && solve(s, dict, end, dp)){
                return dp[i] = true;
            }
        }
        return dp[i] = false;
    }
}