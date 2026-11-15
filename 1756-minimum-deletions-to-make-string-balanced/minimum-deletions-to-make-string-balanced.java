class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int countB = 0;
        int deletions = 0;

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == 'b'){
                countB++;
            }else{
                deletions = Math.min(deletions + 1, countB);
            }
        }
        return deletions;
    }
}