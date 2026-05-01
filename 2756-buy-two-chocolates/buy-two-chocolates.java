class Solution {
    public int buyChoco(int[] prices, int money) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;

        for(int n : prices){
            if(n < a){
                b = a;
                a = n;
            }else if(n < b) b = n;
        }

        int cost = a + b;
        if(cost <= money) return money - cost;
        return money;
    }
}