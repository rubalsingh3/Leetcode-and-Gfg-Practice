class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<groupSizes.length; i++){
            int size = groupSizes[i];
            map.putIfAbsent(groupSizes[i], new ArrayList<>());
            map.get(groupSizes[i]).add(i);

            List<Integer> list = map.get(groupSizes[i]);
            if(list.size() == groupSizes[i]){
                res.add(list);
                map.remove(size);
            }
            
        }
        return res;
    }
}