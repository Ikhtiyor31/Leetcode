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
        int count = 200; 
        for (char c: pref.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                count = 0;
                break;   
            }
            current = current.children[index];
            count = Math.min(count, current.count);
        }

        return count;
    }
}