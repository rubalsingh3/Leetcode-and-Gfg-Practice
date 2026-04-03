class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums) set.add(n);

        List<Integer> res = new ArrayList<>();
        int min = nums[0];
        int max = nums[0];
        for(int n : nums){
            if(n < min) min = n;
            if(n > max) max = n;
        }

        for(int i=min; i<max; i++){
            if(!set.contains(i)) res.add(i);
        }
        return res;
    }
}