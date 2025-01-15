class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> answer = new ArrayList<>();
        for (String word: words) {
            for (String word1: words) {
                if (word.equals(word1)) continue;
                if (word1.indexOf(word) != -1) {
                    answer.add(word);
                    break;
                }
            }
        }

        return answer;
    }
}