class Solution {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        int sum = 0;
        for(int n:nums){
            freq.put(n,freq.getOrDefault(n,0) +1);
        }
        for(HashMap.Entry<Integer,Integer> e : freq.entrySet()){
            if(e.getValue() == 1){
                sum += e.getKey();
            }
        }
        return sum;
    }
}