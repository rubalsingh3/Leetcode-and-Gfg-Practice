class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        int n = val.length;
        double[][] arr = new double[n][2];
        for(int i=0; i<n; i++){
            arr[i][0] = (double) val[i] / wt[i];
            arr[i][1] = (double) wt[i];
        }
        
        Arrays.sort(arr, (a,b) -> Double.compare(b[0], a[0]));
        
        double res = 0.0;
        
        for(int i=0; i<n; i++){
            if(arr[i][1] > capacity){
                res += arr[i][0] * capacity;
                break;
            }else{
                res += arr[i][0] * arr[i][1];
                capacity -= arr[i][1];
            }
        }
        return res;
    }
}