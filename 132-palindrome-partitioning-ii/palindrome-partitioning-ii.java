class Solution {
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);

        Boolean[][] pali = new Boolean[s.length()][s.length()];
        return solve(s, 0, dp, pali) - 1;
    }
    public int solve(String s, int i, int[] dp, Boolean[][] pali){
        if(i == s.length()) return 0;
        if(dp[i] != -1) return dp[i];

        int ans = Integer.MAX_VALUE;
        for(int k=i; k<s.length(); k++){
            if(palin(s, i, k, pali)){
                ans = Math.min(ans, 1 + solve(s, k+1, dp, pali));
            }
        }
        return dp[i] = ans;
    }
    public boolean palin(String s, int i, int j, Boolean[][] pali){
        if(i >= j) return true;

        if(pali[i][j] != null) return pali[i][j];

        if(s.charAt(i) != s.charAt(j)){
            return pali[i][j] = false;
        }

        return pali[i][j] = palin(s, i + 1, j - 1, pali);
    }
}