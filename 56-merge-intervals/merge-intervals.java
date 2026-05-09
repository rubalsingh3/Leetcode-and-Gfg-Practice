class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) return intervals;

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> res = new ArrayList<>();
        int[] temp = intervals[0];
        res.add(temp);
        for(int[] i : intervals){
            if(i[0] <= temp[1]) temp[1] = Math.max(temp[1], i[1]);
            else{
                temp = i;
                res.add(temp);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}