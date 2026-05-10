class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for(char ch : tasks){
            arr[ch - 'A']++;
        }
        Arrays.sort(arr);

        int maxFreq = arr[25];
        int holes = maxFreq - 1;
        int idle = holes * n;

        for(int i=24; i>=0; i--){
            idle -= Math.min(holes, arr[i]);
        }
        if(idle > 0) return idle + tasks.length;

        return tasks.length;
    }
}