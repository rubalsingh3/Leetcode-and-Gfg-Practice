class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] vis = new boolean[n];
        return bfs(adj, vis, source, destination);
    }
    public boolean bfs(List<List<Integer>> adj, boolean[] vis, int node, int dest){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = true;

        while(!q.isEmpty()){
            int temp = q.poll();

            if(temp == dest) return true;

            for(int neigh : adj.get(temp)){
                if(!vis[neigh]){
                    vis[neigh] = true;
                    q.add(neigh);
                }
            }
            
        }
        return false;
    }
}