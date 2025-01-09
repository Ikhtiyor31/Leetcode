class Solution {
    class TrieNode1 {
        TrieNode1[] children;
        int count;
        TrieNode1() {
            children = new TrieNode1[26];
            count = 0;
        }
    }

    class TrieNode2 {
        TrieNode2[] children;
        int count;
        TrieNode2() {
            children = new TrieNode2[26];
            count = 0;
        }
    }
   
    public void addWord1(String word, TrieNode1 current) {
        for (char c: word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode1();
            }
            current = current.children[index];
            current.count++;
        }
    }

    public void addWord2(String word, TrieNode2 current) {
        for (char c: word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode2();
            }
            current = current.children[index];
            current.count++;
        }
    }

    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                TrieNode1 root1 = new TrieNode1();
                TrieNode2 root2 = new TrieNode2();

                // check prefix
                String prefSuff = words[i];
                String word = words[j];
                addWord1(word, root1);
                StringBuffer sb = new StringBuffer(word);
                sb.reverse();
                word = sb.toString();
                addWord2(word, root2);
                TrieNode1 current1 = root1;
                TrieNode2 current2 = root2;
                boolean notFound = false;
                for (char c: prefSuff.toCharArray()) {
                    int index = c - 'a';
                    if (current1.children[index] == null) {
                        notFound = true;
                        break;
                    }
                    current1 = current1.children[index];
                }
                if (notFound) continue;
                StringBuffer sb2 = new StringBuffer(prefSuff);
                sb2.reverse();
                prefSuff = sb2.toString();
                for (char c: prefSuff.toCharArray()) {
                    int index = c - 'a';
                    if (current2.children[index] == null) {
                        notFound = true;
                        break;
                    }
                    current2 = current2.children[index];
                }

                if (!notFound) {
                    count++;
                }
            }
        }
        

        return count;

    }
}