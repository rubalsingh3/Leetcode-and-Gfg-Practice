class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character, Integer> vowel = new HashMap<>();
        HashMap<Character, Integer> con = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                vowel.put(c, vowel.getOrDefault(c, 0) + 1);
            }else{
                con.put(c, con.getOrDefault(c, 0) +1);
            }
        }
        int freq = 0;
        
        int maxVowel = vowel.isEmpty() ? 0 : Collections.max(vowel.values());
        int maxCon = con.isEmpty() ? 0 : Collections.max(con.values());

        freq = maxVowel + maxCon;
        return freq;


    }
}