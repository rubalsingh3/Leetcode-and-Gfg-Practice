class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] dp = new Integer[n][n];

        return solve(triangle, 0, 0, dp);
    }
    public int solve(List<List<Integer>> tri, int i, int j, Integer[][] dp){
        int n = tri.size();

        if(i == n-1) return tri.get(i).get(j);

        if(dp[i][j] != null) return dp[i][j];

        int down = solve(tri, i+1, j, dp);
        int diagonal = solve(tri, i+1, j+1, dp);

        return dp[i][j] = tri.get(i).get(j) + Math.min(down, diagonal);
    }
}