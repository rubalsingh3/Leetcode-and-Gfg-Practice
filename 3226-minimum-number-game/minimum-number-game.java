class Solution {
    public int[] numberGame(int[] nums) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int n : nums) q.add(n);
        Queue<Integer> res = new LinkedList<>();
        while (!q.isEmpty()) {
            int x = q.poll();
            if (!q.isEmpty()) {
                int y = q.poll();
                res.add(y);
                res.add(x);
            }

        }
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (!res.isEmpty())
                arr[i] = res.poll();
        }
        return arr;
    }
}