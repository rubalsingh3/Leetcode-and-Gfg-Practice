class Solution {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(a);
        pq.add(b);
        pq.add(c);
        int res = 0;
        while (pq.size() > 1) {
            int x = pq.poll() - 1;

            int y = pq.poll() - 1;
            res++;
            if (x > 0)
                pq.add(x);
            if (y > 0)
                pq.add(y);

        }
        return res;
    }
}