class Solution {
    public boolean matches(int[] freq1, int[] freq2) {
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        
        int[] freq1 = new int[26];
        
        for (char c: s1.toCharArray()) {
            freq1[c - 'a']++;
        }
     
        
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] freq2 = new int[26];
            for (int j = 0; j < s1.length(); j++) {
                freq2[s2.charAt(i + j) - 'a']++;
            }

            if (matches(freq1, freq2)) {
                return true;
            }
        }


        return false;
    }
}