class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = ages.length;
        int[][] arr = new int[n][2];

        for(int i=0; i<n; i++){
            arr[i][0] = ages[i];
            arr[i][1] = scores[i];
        }
        Arrays.sort(arr, (a,b) ->{
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        }); 

        int[][] dp = new int[n][n];
        for(int[] x : dp) Arrays.fill(x, -1);

        return solve(arr, 0, -1, dp);

    }
    public int solve(int[][] arr, int i, int prev, int[][] dp){
        if(i == arr.length) return 0;

        if(prev != -1 && dp[i][prev] != -1) return dp[i][prev];

        // take condition
        int take = 0;
        if(prev == -1 || arr[prev][1] <= arr[i][1]){
            take = arr[i][1] + solve(arr, i+1, i, dp);
        }
        // skip condition
        int skip = solve(arr, i+1, prev, dp);

        if(prev != -1) dp[i][prev] = Math.max(take, skip);
        return Math.max(take, skip);
    }
}