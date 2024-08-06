class Solution {
    public int minimumPushes(String word) {
        int[] frequency = new int[26];
        for (char c: word.toCharArray()) {
            frequency[c - 'a']++;
        }
        Arrays.sort(frequency);
        int[] sortedFrequency = new int[26];
        for (int i = 25; i >= 0; i--) {
            sortedFrequency[25-i] = frequency[i];
        }

        int count = 0;
        int pushes = 1;
        int answer = 0;
        for (int i = 0; i < 26; i++) {
            if (i != 0 && i % 8 == 0) {
                pushes++;
            }
            answer += (sortedFrequency[i] * pushes);
        }
        return answer;
    }
}