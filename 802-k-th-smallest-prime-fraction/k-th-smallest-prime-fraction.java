class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<float[]> pq = new PriorityQueue<>(
            (a,b) -> Float.compare(a[0],b[0]));
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                pq.add(new float[]{(float)arr[i]/arr[j], arr[i], arr[j]});
            }          
        }
        int[] res = new int[2];
        while(k>0){
            float[] x = pq.poll();
            res[0] = (int)x[1];
            res[1] = (int)x[2];
            k--;
        }
        return res;
    }
}