class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int n : nums) q.add(n);
        int res = 0;
        while(k > 0){
            if(k == 1){
                res = q.poll();
                return res;
            }else{
                q.poll();
                k--;
            }
        }
        return res;
    }
}