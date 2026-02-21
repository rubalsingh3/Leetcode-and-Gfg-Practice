class Solution {
    public int missingNumber(int[] nums) {
        int actualSum = 0;
        int missing = 0;
        int n = nums.length;
        int expectedSum = n*(n+1)/2;
        for(int i : nums){
            actualSum += i;
        }
        missing = expectedSum - actualSum;
        return missing;
        
    }
}