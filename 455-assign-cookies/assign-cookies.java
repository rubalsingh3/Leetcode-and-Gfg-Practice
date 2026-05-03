class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        Arrays.sort(g);

        int cookie = 0;
        int child = 0;
        while(cookie < s.length && child < g.length){
            if(s[cookie] >= g[child]){
                cookie++;
                child++;
            }else{
                cookie++;
            }
        }
        return child;
    }
}