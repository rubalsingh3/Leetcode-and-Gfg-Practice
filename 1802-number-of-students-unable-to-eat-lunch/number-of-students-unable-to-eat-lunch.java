class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> s= new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<students.length; i++) q.add(students[i]);
        for(int i=0; i<sandwiches.length; i++) s.add(sandwiches[i]);
        int rotation = 0;
        while(!s.isEmpty() && !q.isEmpty()){
            if(s.peek() == q.peek()){
                rotation = 0;
                s.remove();
                q.remove();
            }else if(rotation == q.size()) break;
            else{
                int t = q.remove();
                q.add(t);
                rotation++;
            }
        }
        return q.size();
    }
}