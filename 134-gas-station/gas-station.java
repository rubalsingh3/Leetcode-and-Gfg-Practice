class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int index = 0;
        int tank = 0;
        for(int i=0; i<gas.length; i++){
            int temp = gas[i] - cost[i];

            total += temp;
            tank += temp;

            if(tank < 0){
                index = i+1;
                tank = 0;
            }
        }
        return total >= 0 ? index : -1;
    }
}