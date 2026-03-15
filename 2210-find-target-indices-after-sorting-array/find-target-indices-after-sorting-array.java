class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> res = new ArrayList<>();
        int smaller = 0;
        int equal = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] < target) smaller++;
            else if(nums[i] == target) equal++;
        }
        while(equal >0){
            res.add(smaller);
            equal--;
            smaller++;
        }
        return res;
    }
}