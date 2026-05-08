class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalCost = 0;
        int res = 0;
        int totalGas = 0;
        for(int i=0; i<gas.length; i++){
            totalCost += cost[i];
            totalGas += gas[i];
        }
        if(totalCost > totalGas) return -1;
        totalCost = 0;
        
        for(int i=0; i<gas.length; i++){
            totalCost += gas[i] - cost[i];
            if(totalCost < 0){
                res = i+1;
                totalCost = 0;
            }
        }
        
        
        return res;
    }
}