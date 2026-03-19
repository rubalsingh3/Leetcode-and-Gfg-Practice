class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0) +1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        for(Map.Entry<Character,Integer> e : map.entrySet()){
            pq.add(e);
        }
        StringBuilder res = new StringBuilder();
        while(!pq.isEmpty()){
            var x = pq.poll();
            for(int i=0; i<x.getValue(); i++){
                res.append(x.getKey());
            }
        }

        return res.toString();
    }
}