class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int n : gifts) q.add(n);
        while(k > 0){
            int x = q.poll();
            q.add((int)Math.sqrt(x));
            k--;
        }
        long sum = 0;
        while(!q.isEmpty()) sum += q.poll();
        return sum;
    }
}