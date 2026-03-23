class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long m = mass;
        for(int n : asteroids){
            if(n <= m){
                m += n;
                continue;
            }
            else{
                return false; 
            }
        }
        return true;        
    }
}