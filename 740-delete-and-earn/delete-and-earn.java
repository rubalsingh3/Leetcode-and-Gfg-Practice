class Solution {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n : nums) map.put(n, map.getOrDefault(n, 0) + n);

        List<Integer> values = new ArrayList<>(map.keySet());

        Collections.sort(values);
        int take = 0;
        int skip = 0;
        int prev = -1;
        
        for(int num : values){
            int temp = Math.max(take, skip);
            if(num == prev +1){
                take = skip + map.get(num);
            }else{
                take = temp + map.get(num);
            }
            skip = temp;
            prev = num;
        }
        return Math.max(take, skip);
    }
}