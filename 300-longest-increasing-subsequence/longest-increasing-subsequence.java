class Solution {
    public int lengthOfLIS(int[] nums) {
        // 1 to n approach

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++){
            for (int p = 0; p < i; p++){
                if (nums[i] > nums[p])
                    dp[i] = Math.max(dp[i], dp[p] + 1);
            }
        }
        int maxLen = 1;
        for (int i = 0; i < n; i++){
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;

    }
}