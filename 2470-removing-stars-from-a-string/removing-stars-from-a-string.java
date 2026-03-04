class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '*') st.pop();
            else st.push(c);
        }
        StringBuilder res = new StringBuilder();
        for(char c : st) res.append(c);
        return res.toString();
    }
}