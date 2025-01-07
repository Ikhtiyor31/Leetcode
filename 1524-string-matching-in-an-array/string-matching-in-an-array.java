class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> answer = new ArrayList<>();
        String test = "superhero";

        for (String word: words) {
            for (String word2: words) {
                if (!word.equals(word2)) {
                    if (word2.indexOf(word) != -1) {
                        answer.add(word);
                        break;
                    }
                }
            }
        }
        
        return answer;

    }
}