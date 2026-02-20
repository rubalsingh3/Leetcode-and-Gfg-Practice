class Solution {
    public int[] runningSum(int[] nums) {
        int runsum = 0;
        int res[] = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            
            runsum += nums[i];
            res[i] = runsum;
            
        }

        return res;
    }
}