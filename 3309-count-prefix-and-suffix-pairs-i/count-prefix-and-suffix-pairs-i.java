class Solution {
    class TrieNode {
        TrieNode[] children;
        int count;
        TrieNode() {
            children = new TrieNode[26];
        }
    }
   
    public void addWord(String word, TrieNode current) {
        for (char c: word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
            current.count++;
        }
    }

    public boolean startsWith(String word, TrieNode current) {
        for (char c: word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }

        return true;
    } 

    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                TrieNode prefixTrie = new TrieNode();
                TrieNode suffixTrie = new TrieNode();

                // prefix insert
                String word = words[j];
                addWord(word, prefixTrie);

                // suffix insert
                word = new StringBuffer(word)
                    .reverse()
                    .toString();
                addWord(word, suffixTrie);
                
                String prefix = words[i];
                String suffix = new StringBuffer(prefix)
                    .reverse()
                    .toString();

                if (startsWith(prefix, prefixTrie) && startsWith(suffix, suffixTrie)) {
                    count++;
                }
            }
        }
        

        return count;

    }
}