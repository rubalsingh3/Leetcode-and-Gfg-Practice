class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for(int i=0; i<nums.length; i++){
            q.offer(new int[]{nums[i],i});
        }
        while(k > 0){
            int[] x = q.poll();
            x[0] *= multiplier;
            q.offer(x);
            k--;
        }
        int[] res = new int[nums.length];
        while(!q.isEmpty()){
            int[] x = q.poll();
            res[x[1]] = x[0];
        }
        return res;
    }
}