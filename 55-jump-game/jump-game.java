class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for(int i=0; i<nums.length; i++){
            if(i > maxReach) return false;
            if(maxReach > nums.length) break;
            maxReach = Math.max(maxReach, nums[i] + i);
        }
        return true;
    }
}