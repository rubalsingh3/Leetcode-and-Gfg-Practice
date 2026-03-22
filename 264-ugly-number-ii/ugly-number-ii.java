class Solution {
    public int nthUglyNumber(int n) {
        HashSet<Long> set = new HashSet<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(1L);
        set.add(1L);
        long res = 0;

        for(int i=0; i<n; i++){
            res = pq.poll();
            long a = res * 2;
            long b = res * 3;
            long c = res * 5;

            
            if(!set.contains(a)){
                pq.add(a);
                set.add(a);
            }
            if(!set.contains(b)){
                pq.add(b);
                set.add(b);
            }
            if(!set.contains(c)){
                pq.add(c);
                set.add(c);
            }
        }
       
        
        
        return (int) res;
    }
}