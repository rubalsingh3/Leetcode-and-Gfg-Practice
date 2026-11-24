class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        int n = s.length();

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j <= n; j++){
                String sub = s.substring(i, j);

                if(solve(s, i, j-1)) res++;
            }
        }

        return res;
    }
    public boolean solve(String s, int i, int j){
        if(i >= j) return true;

        if(s.charAt(i) != s.charAt(j)){
            return false;
        }

        return solve(s, i+1, j-1);
    }
}