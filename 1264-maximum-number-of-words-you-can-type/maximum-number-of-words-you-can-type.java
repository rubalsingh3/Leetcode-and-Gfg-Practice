class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        HashSet<Character> set = new HashSet<>();
        for(char c : brokenLetters.toCharArray()) set.add(c);

        int count = 0;
        String[] words = text.split(" ");
        for(String s : words){
            boolean cantype = true;
            for(char c : s.toCharArray()){
                if(set.contains(c)) cantype = false;
            }
            if(cantype) count++;
        }
        return count;
    }
}