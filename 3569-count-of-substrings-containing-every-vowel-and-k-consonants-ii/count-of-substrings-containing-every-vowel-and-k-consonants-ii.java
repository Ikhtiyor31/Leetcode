class Solution {
    public boolean isVowel(char c) {
        return c == 'a' || c == 'u' || c == 'i' || c == 'e' || c == 'o';
    }
    public long countOfSubstrings(String word, int k) {
        int n = word.length();
        HashMap<Character, Integer> vowelCount = new HashMap<>();
        int consonants = 0;
        int[] nextConsonant = new int[n];
        int nextConsonantIndex = n;
        for (int i = n - 1; i >= 0; i--) {
            nextConsonant[i] = nextConsonantIndex;
            if (!isVowel(word.charAt(i))) {
                nextConsonantIndex = i;
            }
        }

        int l = 0;
        int r = 0;
        int consonant = 0;
        long answer = 0;
        while (r < n) {
            if (isVowel(word.charAt(r))) {
                vowelCount.put(word.charAt(r), vowelCount.getOrDefault(word.charAt(r), 0) + 1);
            } else {
                consonant += 1;
            }

            while (consonant > k) {
                if (isVowel(word.charAt(l))) {
                    vowelCount.put(word.charAt(l), vowelCount.getOrDefault(word.charAt(l), 0) - 1);
                    if (vowelCount.get(word.charAt(l)) == 0) {
                        vowelCount.remove(word.charAt(l));
                    }
                } else {
                    consonant -= 1;
                }
                l += 1;
            }

            while (vowelCount.size() == 5 && k == consonant) {
                answer += nextConsonant[r] - r;
                if (isVowel(word.charAt(l))) {
                    vowelCount.put(word.charAt(l), vowelCount.getOrDefault(word.charAt(l), 0) - 1);
                    if (vowelCount.get(word.charAt(l)) == 0) {
                        vowelCount.remove(word.charAt(l));
                    }
                } else {
                    consonant -= 1;
                }
                l += 1;
            }
            r += 1;
        }
        return answer;

    }
}