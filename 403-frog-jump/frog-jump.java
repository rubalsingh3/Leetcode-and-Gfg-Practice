class Solution {
    public boolean canCross(int[] stones) {
        if(stones[1] != 1) return false;

        Boolean dp[][] = new Boolean[stones.length][stones.length+1];

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<stones.length; i++){
            map.put(stones[i], i);
        }

        return solve(stones, 0, 0, map, dp);
    }

    public boolean solve(int[] stones, int csi, int prevJump, HashMap<Integer, Integer> map, Boolean[][] dp) {
        if(csi == stones.length-1) return true;
        
        if(dp[csi][prevJump] != null) return dp[csi][prevJump];

        for(int nextJump = prevJump-1; nextJump <= prevJump+1; nextJump++) {
            if(nextJump > 0) {
                int nextStone = stones[csi] + nextJump;
                if(map.containsKey(nextStone)) {
                    if(solve(stones, map.get(nextStone), nextJump, map, dp)) {
                        return dp[csi][prevJump] =  true;
                    }
                }
            }
        }
        return dp[csi][prevJump] = false;
    }
}