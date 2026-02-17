class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> s = new Stack<>();
        int res = 0;
        for(int i = 0; i< operations.length; i++){
            int temp = 0;
            if(operations[i].equals("+")){
                int a = s.pop();
                int b = s.peek();
                s.push(a);
                s.push(a+b);
            }
            else if(operations[i].equals("D")){
                s.push(s.peek()*2);
            }
            else if(operations[i].equals("C")){
                s.pop();
            }
            else{
                s.push(Integer.parseInt(operations[i]));
            }
        }
        while(!s.isEmpty()){
            res += s.pop();
        }
        return res;
    }
}