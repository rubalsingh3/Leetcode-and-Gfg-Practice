class Solution {
    public int minimumOperations(int[] nums) {
        boolean[] visited = new boolean[101];
        int count = 0;
        for(int n : nums){
            if(n != 0 && !visited[n]){
                visited[n] = true;
                count++;
            }
        }
        return count;
    }
}