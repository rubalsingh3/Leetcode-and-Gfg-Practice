class Solution {
    public int thirdMax(int[] nums) {
        long m1 = Long.MIN_VALUE, m2 = Long.MIN_VALUE, m3 = Long.MIN_VALUE;  
        for(int n : nums){
            if(m1 == n || m2 == n || m3 == n) continue;
            if(n > m1){
                m3 = m2;
                m2 = m1;
                m1 = n;
            }
            else if(n > m2){
                m3 = m2;
                m2 = n;
            }
            else if(n > m3){
                m3 = n;
            }
        }
        return m3 == Long.MIN_VALUE ? (int)m1 : (int)m3;
    }
}