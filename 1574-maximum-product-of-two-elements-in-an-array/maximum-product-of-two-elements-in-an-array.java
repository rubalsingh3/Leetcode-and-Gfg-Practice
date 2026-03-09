class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int n : nums) q.add(n);
        int x = q.poll()-1;
        int y = q.poll()-1;
        return x *y;
    }
}