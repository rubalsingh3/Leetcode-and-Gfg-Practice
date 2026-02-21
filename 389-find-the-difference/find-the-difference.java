class Solution {
    public char findTheDifference(String s, String t) {
        char c = 0;
        for(char n : s.toCharArray()){
            c ^=n;
        }
        for(char n : t.toCharArray()){
            c = (char)(c^n);
        }
        return c;
    }
}