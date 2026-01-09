class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        boolean[] vis = new boolean[n];
        return dfs(graph,vis,source,destination);
    }
    public boolean dfs(List<List<Integer>> graph, boolean[] vis, int node, int dest){
        if(node == dest) return true;
        vis[node] = true;
        for(int nei : graph.get(node)){
            if(!vis[nei]){
                if(dfs(graph,vis,nei,dest)) return true;
            }
        }
        return false;
    }
}