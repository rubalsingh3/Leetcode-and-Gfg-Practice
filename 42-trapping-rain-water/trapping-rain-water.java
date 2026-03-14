class Solution {
    public int trap(int[] height) {
        int totalWater = 0;
        int n = height.length;
        if(n<3) return 0;
        
        int[] left = new int[n];
        left[0] = height[0];
        int[] right = new int[n];
        right[n-1] = height[n-1];

        for(int i=1; i<n; i++){
            left[i] = Math.max(left[i-1], height[i]);
        }
        for(int i=n-2; i>=0; i--){
            right[i] = Math.max(right[i+1], height[i]);
        }
        for(int i=0; i<n; i++){
            int waterLevel = Math.min(left[i], right[i]);
            int trappedWater = waterLevel - height[i];
            totalWater += trappedWater;
        }
        return totalWater;
    }
}