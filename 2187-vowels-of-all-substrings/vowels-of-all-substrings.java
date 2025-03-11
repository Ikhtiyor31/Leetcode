class Solution {
    public boolean isVowel(char c) {
        return c == 'a' || c == 'u' || c == 'i' || c == 'e' || c == 'o';
    }

    public long countVowels(String word) {
        long total_substrings = 0;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            if (isVowel(word.charAt(i)))
                total_substrings += (long)(i + 1) * (long)(n - i);
        }

        return total_substrings;
    }
}