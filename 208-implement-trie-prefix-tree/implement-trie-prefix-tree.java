
class Trie {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
        public TrieNode() {
            for (int i = 0; i < 26; i++) {
                this.children[i] = null;
            }
        }
    }

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode current = root;
        for (char c: word.toCharArray()) {
            int idx = c - 'a';
            if (current.children[idx] == null) {
                current.children[idx] = new TrieNode();
            }
            current = current.children[idx];
        }
        current.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode current = root;
        for (char c: word.toCharArray()) {
            int idx = c - 'a';
            if (current.children[idx] == null) {
                return false;
            }
            current = current.children[idx];
        }
        return current.isEnd;
    }

    
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c: prefix.toCharArray()) {
            int idx = c - 'a';
            if (current.children[idx] == null) {
                return false;
            }
            current = current.children[idx];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */