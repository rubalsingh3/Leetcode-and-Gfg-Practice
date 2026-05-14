// User function Template for Java

class Solution {
    static int sumOfNaturals(int n) {
        // code here
        return sum(n);
    }
    static int sum(int n){
        if(n == 0 || n == 1) return n;
        return n + sum(n-1);
    }
};