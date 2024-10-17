class WordDictionary {
    static class Trie {
        Trie[] children;
        boolean isEnd;
        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }
    }
    Trie root;
    public WordDictionary() {
        root = new Trie();
    }
    
    public void addWord(String word) {
        Trie current = root;
        for (char c: word.toCharArray()) {
            int idx = c - 'a';
            if (current.children[idx] == null) {
                current.children[idx] = new Trie();
            }
            
            current = current.children[idx];
        }
        current.isEnd = true;
    }
    
    public boolean search(String word) {

        return dfs(word.toCharArray(), root, 0);
    }

    public boolean dfs(char[] word, Trie root, int i) {

        if (i == word.length) {
            return root.isEnd;
        }

        if (word[i]== '.'){
            for (int c = 0; c < 26; c++) {
                if (root.children[c] != null && dfs(word, root.children[c], i + 1))
                    return true;
            }
        } else {
            int idx = word[i] - 'a';
            if (root.children[idx] != null && dfs(word, root.children[idx], i + 1)) {
                return true;
            }
        }

        return false;

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */