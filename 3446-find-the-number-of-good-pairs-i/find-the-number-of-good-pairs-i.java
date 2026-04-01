class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int count = 0;
        for(int i=0; i<nums1.length; i++){
            for(int j=0; j<nums2.length; j++){
                int x = nums2[j] * k;
                if(nums1[i] % x == 0) count++;
            }
        }
        return count;
    }
}