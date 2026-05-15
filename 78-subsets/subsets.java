class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        
        sub(0, nums, res, curr);
        return res;
    }
    public void sub(int index, int[] nums, List<List<Integer>> res, List<Integer> curr){
        if(index == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        
        curr.add(nums[index]);
        sub(index+1, nums, res, curr);

        curr.remove(curr.size() -1);

        sub(index+1, nums, res, curr);    
    }
}