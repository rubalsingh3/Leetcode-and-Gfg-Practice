class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;

        if(n == 0) return 0;

        Arrays.sort(envelopes, (a, b) -> {
            if(a[0] == b[0]){
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        
        

        int[] ans = new int[n];
        int len = 0;
        
        for(int i=0; i<n; i++){
            int height = envelopes[i][1];
            int low = 0;
            int high = len;

            while(low < high){
                int mid = low + (high - low) / 2;
                if(ans[mid] < height){
                    low = mid + 1;
                }else {
                    high = mid;
                }
            }

            ans[low] = height;

            if(low == len) len++;
        }
        return len;
    }
}