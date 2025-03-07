class Solution {

    public int minDistance(String word1, String word2, int i, int j, HashMap<String, Integer> memo) {
        String key = i + "," + j;
        if (i == 0) {
            return j; // if word1 is empty, insert all characters 
        }

        if (j == 0) {
            return i; // if word2 is empty, delete all characters
        }

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (word1.charAt(i - 1) == word2.charAt(j-1)) {
            return minDistance(word1, word2, i - 1, j - 1, memo);
        }
        int delete = minDistance(word1, word2, i - 1, j, memo);
        int replace = minDistance(word1, word2, i, j - 1, memo);
        int insert = minDistance(word1, word2, i - 1, j - 1, memo);
        memo.put(key, Math.min(insert, Math.min(delete, replace)) + 1);
        return Math.min(insert, Math.min(delete, replace)) + 1;
    }

    public int minDistance(String word1, String word2) {
        return minDistance(word1, word2, word1.length(), word2.length(), new HashMap<>());
    }
}