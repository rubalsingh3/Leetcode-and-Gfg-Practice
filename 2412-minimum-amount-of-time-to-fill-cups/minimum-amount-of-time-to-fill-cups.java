class Solution {
    public int fillCups(int[] amount) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int n : amount){
            if(n>0) q.add(n);
        }
        int time = 0;
        while(!q.isEmpty()){
            int x = q.poll() - 1;
            if(!q.isEmpty()){
                int y = q.poll() - 1;;
                if(y > 0) q.add(y);
            }
            if(x > 0) q.add(x);
            time++;
        }
        return time;
    }
}