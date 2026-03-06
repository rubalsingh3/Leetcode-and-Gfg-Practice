class Solution {
    public String clearDigits(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            st.push(c);
            if (Character.isDigit(st.peek())){
                st.pop();
                if(!st.isEmpty()){
                    st.pop();
                }
            } 
            
        }
        StringBuilder res = new StringBuilder();
        for (char c : st) res.append(c);
        return res.toString();
    }
}