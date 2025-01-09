class WordDictionary {

     class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    TrieNode root;
    public WordDictionary() {
         root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode current = root;
        for (char c: word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEnd = true;
    }
    
    public boolean search(String word) {
        

        return dfs(word.toCharArray(), root, 0);
    }

    public boolean dfs(char[] word, TrieNode root, int index) {
        if (index == word.length) {
            return root.isEnd;
        }
   
        if (word[index] == '.') {
            for (char c = 'a'; c <= 'z'; c++) {
                word[index] = c;
                if(dfs(word, root, index)) {
                    return true;
                }
                word[index] = '.';
            }
        } else {
            int indx = word[index] - 'a';
            root = root.children[indx];
            if (root != null && dfs(word, root, index + 1)) {
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