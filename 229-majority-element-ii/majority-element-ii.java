class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int c1 = 0, c2 = 0;
        int a = -1, b = -1;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == a) c1++;
            else if(nums[i] == b) c2++;
            else if(c1 == 0) {
                a = nums[i];
                c1++;
            }
            else if(c2 == 0){
                b = nums[i];
                c2++;
            } 
            else{
                c1--;
                c2--;
            }
            
        } 
        c1 = 0; c2 = 0;
        for(int i=0;i<nums.length;i++){
            if(a == nums[i]) c1++;
            else if(b == nums[i]) c2++;
        }

        if(c1 > nums.length/3) ans.add(a);
        if(c2 > nums.length/3) ans.add(b);
        
        return ans;
    }
}