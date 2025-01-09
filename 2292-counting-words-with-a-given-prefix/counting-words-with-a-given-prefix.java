class Solution {
    class TrieNode {
        TrieNode[] children;
        int count;
        TrieNode() {
            children = new TrieNode[26];
            count = 0;
        }
    }
    TrieNode root = new TrieNode();
    public void addWord(String word) {
        TrieNode current = root;
        for (char c: word.toCharArray()) {
            int index = (int) c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
            current.count++;
        }
    }

    public int prefixCount(String[] words, String pref) {
        
        
        for (String word: words) {
            addWord(word);
        }

        TrieNode current = root;
        for (char c: pref.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return 0;  
            }
            current = current.children[index];
        }

        return current.count;
    }
}