class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer,Integer> hash = new HashMap<>();
        for(int x: nums){
            hash.put(x,hash.getOrDefault(x,0) +1 );
            }
        
        for(HashMap.Entry<Integer,Integer> e : hash.entrySet()){
            if(e.getValue() == 2){
                res.add(e.getKey());
            }
        }
        return res;
    }
}