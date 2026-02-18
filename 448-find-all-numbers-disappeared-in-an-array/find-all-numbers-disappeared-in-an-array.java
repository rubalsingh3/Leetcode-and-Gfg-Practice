class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> h = new HashSet<>();
        for(int n : nums) h.add(n);
        for(int i = 1; i<nums.length+1; i++){
            if(!h.contains(i)){
                ans.add(i);
            }
        }
        return ans;
    }
}