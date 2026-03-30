class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> set = new HashSet<>();
        for(char c : allowed.toCharArray()) set.add(c);

        int res = words.length;
        for(int i=0; i<words.length; i++){
            for(char c : words[i].toCharArray()){
                if(!set.contains(c)){
                    res--;
                    break;

                }
            }
        }
        return res;
    }
}