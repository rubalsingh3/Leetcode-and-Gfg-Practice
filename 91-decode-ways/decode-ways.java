class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return countWays(0, s, n, dp);
    }

    public int countWays(int i, String s, int n, int[] dp){
        if(dp[i] != -1) return dp[i];
        if(i == n) return dp[i] = 1;
        if(s.charAt(i) == '0') return dp[i] = 0;

        int res = countWays(i + 1, s, n, dp);

        if(i+1 < n){
            if(s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i+1) <= '6'){
                res += countWays(i+2, s, n, dp);
            }
        }
        return dp[i] = res;
        
    }
}