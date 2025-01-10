class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuffer answer = new StringBuffer();
        int i = 0;
        for (; i < Math.max(word1.length(), word2.length()); i++) {
            if (i < word1.length())
                answer.append(word1.charAt(i));
            if (i < word2.length())
                answer.append(word2.charAt(i));
        }


        return answer.toString();
    }
}