class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c: s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 2) {
                int removed = freq[i] - (freq[i] % 2 == 0 ? 2 : 1);
                System.out.println(removed);
                n -= removed;
            }
        }

        return n;
    }
}