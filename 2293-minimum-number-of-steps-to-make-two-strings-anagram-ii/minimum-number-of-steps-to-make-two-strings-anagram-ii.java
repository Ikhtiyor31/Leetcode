class Solution {
    public int minSteps(String s, String t) {
        int[] freq = new int[26];
        for (char c: s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c: t.toCharArray()) {
            freq[c - 'a']--;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += Math.abs(freq[i]);
        }

        return count;
    }
}