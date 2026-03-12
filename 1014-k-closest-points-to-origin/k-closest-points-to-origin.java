class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int dist = 0;
        for (int i = 0; i < points.length; i++) {
            dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            pq.add(new int[] { dist, points[i][0], points[i][1] });
        }

        int[][] res = new int[k][2];
        int i = 0;
        while (k > 0) {
            int[] top = pq.poll();
            res[i][0] = top[1];
            res[i][1] = top[2];
            i++;
            k--;
        }
        return res;
    }
}