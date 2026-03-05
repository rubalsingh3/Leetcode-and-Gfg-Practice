class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<tickets.length; i++){
            q.add(new int[]{tickets[i],i});
        }
        int time = 0;
        while(true){
            int person[] = q.remove();
            person[0]--;
            time++;

            if(person[0] == 0){
                if(person[1] == k) return time;
            }else{
                q.add(person);
            }
        }       
    }
}