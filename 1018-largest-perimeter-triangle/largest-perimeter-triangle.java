class Solution {
    public int largestPerimeter(int[] nums) {
        // int valid = 0;
        int n = nums.length-1;
        Arrays.sort(nums);
        for(int i=n; i>=2; i--){
            int a = nums[i-2];
            int b = nums[i-1];
            int c = nums[i];
            if (a+b>c) {
                return a+b+c;
            }
        }
        return 0;
    }
}