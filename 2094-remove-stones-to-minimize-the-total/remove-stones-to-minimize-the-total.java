class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int n : piles){
            pq.add(n);
        }
        while(k > 0){
            int x = pq.poll();
            int y = (int)(x/2);
            pq.add(x-y);
            k--;
        }
        int sum = 0;
        while(!pq.isEmpty()){
            sum += pq.poll();
        }
        return sum;
    }
}