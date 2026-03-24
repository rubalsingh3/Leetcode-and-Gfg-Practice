class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums)
            pq.add(n);

        while (k > 0) {
            pq.add(pq.poll() + 1);
            k--;
        }
        long res = 1;
        int mod = 1000000007;
        while(!pq.isEmpty()){
            res = (res * pq.poll()) % mod;
        }

        return (int) res;
    }
}