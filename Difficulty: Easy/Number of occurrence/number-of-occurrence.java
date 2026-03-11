class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        int first = firstOccur(arr, target);
        int last = lastOccur(arr, target);
        if(first == -1) return 0;
        return last - first + 1;
    }


    public int firstOccur(int[] nums, int target){
        int start = 0; int end = nums.length-1;
        int ans = -1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                ans = mid;
                end = mid-1;
                
            }else if(nums[mid] < target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return ans;
    }
    public int lastOccur(int[] nums, int target){
        int start = 0; int end = nums.length-1;
        int ans = -1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                ans = mid;
                start = mid+1;
            }else if(nums[mid] < target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return ans;
    }

}
