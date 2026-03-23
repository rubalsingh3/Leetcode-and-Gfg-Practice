class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        for (int n : asteroids) {
            boolean alive = true;
            while (!s.isEmpty() && s.peek() > 0 && n < 0) {
                int y = Math.abs(n);
                int x = s.peek();
                
                if (x > y){
                    alive = false;
                    break;
                }
                if (x < y) {
                    s.pop();
                    continue;
                }
                if(x == y){
                    s.pop();
                    alive = false;
                    break;
                }
                
            }
            if(alive) s.push(n);

        }
        int[] res = new int[s.size()];
        int i = s.size()-1;
        while(!s.isEmpty()){
            res[i] = s.pop();
            i--;
        }
        return res;

    }
}