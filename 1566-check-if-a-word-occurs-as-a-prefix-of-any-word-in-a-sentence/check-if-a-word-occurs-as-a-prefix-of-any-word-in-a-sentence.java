class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String [] sentenceArray = sentence.split(" ");
        int indx = 0;
        for (String word: sentenceArray) {
            indx++;
            for (int i = 0; i < word.length(); i++) {
                if (searchWord.equals(word.substring(0, i + 1))) {
                    return indx;
                }
            }
        }

        return -1;
    }
}