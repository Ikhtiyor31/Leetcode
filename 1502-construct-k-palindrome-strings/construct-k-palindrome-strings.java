class Solution {
    public boolean canConstruct(String s, int k) {
        int[] freq = new int[26];

        for (char c: s.toCharArray()) {
            freq[c - 'a']++;
        }

        int even = 0;
        int odd = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                even += freq[i] - 1;
                odd += freq[i] >= 1 ? 1 : 0;
            } else {
                even += freq[i];
            }
        }

        if (odd > k || even + odd < k) return false;

        return true;
    }
}

// annabelle aa, nn, ee, ll