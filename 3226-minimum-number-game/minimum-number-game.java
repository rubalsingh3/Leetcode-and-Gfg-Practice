class Solution {
    public int[] numberGame(int[] nums) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int n : nums)
            q.add(n);
        int[] arr = new int[nums.length];
        int index = 0;
        while (!q.isEmpty()) {
            int x = q.poll();

            int y = q.poll();
            arr[index++] = y;
            arr[index++] = x;

        }

        return arr;
    }
}