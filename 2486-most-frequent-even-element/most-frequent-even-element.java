class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n : nums){
            if(n % 2 == 0){
                map.put(n, map.getOrDefault(n,0)+1);
            }
        }
        
        int max = -1;
        int maxfre = Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            int key = e.getKey();
            int freq = e.getValue();
            if(freq > maxfre || (freq == maxfre && max > key)){
                maxfre = freq;
                max = key;
            }
        }
        
        return max; 
        
    }
}