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

    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                TrieNode prefixTrie = new TrieNode();
                TrieNode suffixTrie = new TrieNode();

                // check prefix
                String prefSuff = words[i];
                String word = words[j];
                addWord(word, prefixTrie);
                StringBuffer sb = new StringBuffer(word);
                sb.reverse();
                word = sb.toString();
                addWord(word, suffixTrie);
                boolean notFound = false;
                for (char c: prefSuff.toCharArray()) {
                    int index = c - 'a';
                    if (prefixTrie.children[index] == null) {
                        notFound = true;
                        break;
                    }
                    prefixTrie = prefixTrie.children[index];
                }
                if (notFound) continue;
                StringBuffer sb2 = new StringBuffer(prefSuff);
                sb2.reverse();
                prefSuff = sb2.toString();
                for (char c: prefSuff.toCharArray()) {
                    int index = c - 'a';
                    if (suffixTrie.children[index] == null) {
                        notFound = true;
                        break;
                    }
                    suffixTrie = suffixTrie.children[index];
                }

                if (!notFound) {
                    count++;
                }
            }
        }
        

        return count;

    }
}