class Solution {
    public int maximum69Number (int num) {
        int placeVal = 0;
        int placeVal6 = -1;
        int temp = num;

        while(temp > 0){
            int rem = temp%10;
            
            if(rem == 6){
                placeVal6 = placeVal;
            }  
            placeVal++;
            temp = temp/10;
        }

        if(placeVal6 == -1) return num;
        
        double res = num + 3*Math.pow(10, placeVal6);
        return (int) res;
    }
}