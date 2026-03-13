class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        for(int i=0; i<score.length; i++){
            pq.add(new int[]{score[i], i});
        }
        String[] res = new String[score.length];
        int rank = 0;
        if(!pq.isEmpty()){
            int[] x = pq.poll();
            res[x[1]] = "Gold Medal";
            rank++;
        }if(!pq.isEmpty()){        
            int[] y = pq.poll();
            res[y[1]] = "Silver Medal";
            rank++;
        }if(!pq.isEmpty()){    
            int[] z = pq.poll();
            res[z[1]] = "Bronze Medal";
            rank++;
        }while(!pq.isEmpty()){
            int[] cur = pq.poll();
            rank++;
            res[cur[1]] = String.valueOf(rank);
        }
        return res;
    }
}