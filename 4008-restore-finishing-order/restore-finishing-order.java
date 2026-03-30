class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        HashSet<Integer> set = new HashSet<>();
        for(int f : friends) set.add(f);

        int[] res = new int[friends.length];
        int index = 0;
        for(int i=0; i<order.length; i++){
            if(set.contains(order[i])){
                res[index] = order[i];
                index++;
            }
        }
        return res;
    }
}