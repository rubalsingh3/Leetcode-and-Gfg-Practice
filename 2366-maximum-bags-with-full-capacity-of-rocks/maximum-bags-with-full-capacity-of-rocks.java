class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] req = new int[rocks.length];
        for(int i=0; i<capacity.length; i++){
            req[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(req);
        int count = 0;
        for(int n : req){
            if(additionalRocks >= n){
                additionalRocks -= n;
                count++;
            } 
        }
        return count;
    }
}