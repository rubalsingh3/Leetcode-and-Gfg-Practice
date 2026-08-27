class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] points = new int[10001];

        for(int n : nums) {
            points[n] += n;
        }

        int take = 0;
        int skip = 0;

        for(int num = 1; num <= 10000; num++) {
            int temp = Math.max(take, skip);

            take = skip + points[num];
            skip = temp;
        }

        return Math.max(take, skip);
    }
}