class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(days, costs, n, 0, dp);
    }
    public int solve(int[] days, int[] costs, int n, int i, int[] dp){
        if(i >= n) return 0;

        if(dp[i] != -1) return dp[i];
        // 1 day pass
        int costOfOne = costs[0] + solve(days, costs, n, i+1, dp);
        
        // 7 days pass
        int j = i;
        int maxDays = days[i] + 7;
        while(j < n && days[j] < maxDays){
            j++;
        }
        int costOfSeven = costs[1] + solve(days, costs, n, j, dp);

        // 30 days pass
        j = i;
        maxDays = days[i] + 30;
        while(j < n && days[j] < maxDays){
            j++;
        }
        int costOfThirty = costs[2] + solve(days, costs, n, j, dp);

        return dp[i] = Math.min(costOfOne, Math.min(costOfSeven, costOfThirty));
    }
}