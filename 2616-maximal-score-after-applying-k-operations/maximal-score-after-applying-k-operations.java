class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int n : nums)
            pq.add((long) n);

        long sum = 0;

        while (k > 0) {
            long cur = pq.poll();
            sum += cur;
            pq.add((long) Math.ceil((cur / 3.0)));
            k--;
        }
        return sum;
    }
}