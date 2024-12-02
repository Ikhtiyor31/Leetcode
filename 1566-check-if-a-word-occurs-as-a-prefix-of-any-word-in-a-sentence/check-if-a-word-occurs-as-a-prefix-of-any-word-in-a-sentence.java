class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String [] sentenceArray = sentence.split(" ");
        int indx = 0;
        for (String word: sentenceArray) {
            indx++;
            for (int i = 0; i < Math.min(searchWord.length(), word.length()); i++) {
                if (searchWord.charAt(i) == word.charAt(i) && searchWord.length() - 1 == i) {
                    return indx;
                }
                if (searchWord.charAt(i) != word.charAt(i)) {
                    break;
                }
            }
        }

        return -1;
    }
}