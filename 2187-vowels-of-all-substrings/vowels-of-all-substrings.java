class Solution {
    public boolean isVowel(char c) {
        return c == 'a' || c == 'u' || c == 'i' || c == 'e' || c == 'o';
    }

    public long countVowels(String word) {
        long count = 0;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            if (isVowel(word.charAt(i)))
                count += (long)(n - i) * (long)(i + 1);
        }

        return count;
    }
}