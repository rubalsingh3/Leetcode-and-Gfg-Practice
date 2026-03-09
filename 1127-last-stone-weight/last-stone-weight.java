class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int res = 0;
        for (int i : stones)
            q.add(i);
        while (!q.isEmpty()) {
            int x = q.poll();
            if (!q.isEmpty()) {
                int y = q.poll();
                if (x != y) {
                    q.add(x - y);
                }
            }else{
                res = x;
            }

        }
        return res;
    }
}