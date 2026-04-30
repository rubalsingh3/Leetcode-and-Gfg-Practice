class Solution {
    public int maximizeSum(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int n : nums) pq.add(n);

        int sum = 0;

        while(k > 0){
            int temp = pq.poll();
            sum += temp;
            pq.add(temp+1);
            k--;
        }
        return sum;
    }
}