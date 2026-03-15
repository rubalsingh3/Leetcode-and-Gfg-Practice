class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        // int left = 0;
        // int right = nums.length-1;
        // while(left<=right){
        //     int mid = left + (right-left)/2;
        //     if(target == nums[mid]) res.add(mid);
        //     if(target > nums[mid]) left = mid+1;
        //     else right = mid-1;
        // }
        // Collections.sort(res);

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
        


        // for(int i=0; i<nums.length; i++){
        //     if(nums[i] == target) res.add(i);
        // }
        
        return res;
    }
}