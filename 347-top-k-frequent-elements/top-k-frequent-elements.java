class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]- b[0]);
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            pq.add(new int[]{e.getValue(), e.getKey()});

            if(pq.size() > k) pq.poll();
        }
        int[] res = new int[k];
        int i = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            res[i] = cur[1];
            i++;
        }
        return res;
    }
}