class Solution {
    class TrieNode {
        TrieNode[] children;
        List<String> suggestedProducts;
        public TrieNode() {
            children = new TrieNode[26];
            suggestedProducts = new ArrayList<>();
        }
    }
    TrieNode root = new TrieNode();
    public void addWord(String word) {
        TrieNode current = root;
        for (char c: word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
            current.suggestedProducts.add(word);
            Collections.sort(current.suggestedProducts);
            if (current.suggestedProducts.size() > 3) {
                current.suggestedProducts.remove(current.suggestedProducts.size()-1);
            }
            
        }
    }


    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        for (String product: products) {
            addWord(product);
        }
        Arrays.sort(products);
        List<List<String>> answer = new ArrayList<>();
        TrieNode current = root;
        for (char c: searchWord.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] != null) {
                current = current.children[index];
                answer.add(current.suggestedProducts); 
                continue;
            }
            while (answer.size() < searchWord.length()) {
                answer.add(new ArrayList<>());
            }
            break;
            
        }

        

        return answer;
    }
}