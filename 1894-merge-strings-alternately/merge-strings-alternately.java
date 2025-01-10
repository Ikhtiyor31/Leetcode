class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuffer answer = new StringBuffer();
        int i = 0;
        for (; i < Math.min(word1.length(), word2.length()); i++) {
            answer.append(word1.charAt(i));
            answer.append(word2.charAt(i));
        }

        while (i < word1.length()) {
            answer.append(word1.charAt(i++));
        }
        while (i < word2.length()) {
            answer.append(word2.charAt(i++));
        }

        return answer.toString();
    }
}