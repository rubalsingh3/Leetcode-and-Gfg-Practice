class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<deck.length; i++){
            q.add(i);
        }
        int[] res = new int[deck.length];
        for(int i=0; i<deck.length; i++){
            int x = q.remove();
            res[x] = deck[i];
            if(!q.isEmpty()){
                q.add(q.remove());
            }
             
        }
        return res;
    }
}