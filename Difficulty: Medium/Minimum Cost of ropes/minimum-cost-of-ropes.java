class Solution {
    public static int minCost(int[] arr) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : arr) pq.add(n);
        int cost = 0;
        while(!pq.isEmpty()){
            int x = pq.poll();
            if(!pq.isEmpty()){
                int y = pq.poll();
                int sum = x + y;
                cost += sum;
                pq.add(sum);
            }
        }
        return cost;
    }
}