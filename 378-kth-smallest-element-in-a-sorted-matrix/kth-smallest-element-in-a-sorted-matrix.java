class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                pq.add(matrix[i][j]);
            }
        }
        int res = -1;
        while(k>0){
            int x =pq.poll();
            res = x;
            k--;
        }
        return res;
    }
}