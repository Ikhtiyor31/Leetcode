class Solution {
    class Trie {
        Trie[] children;
        String isEnd;
        public Trie() {
            this.children = new Trie[26];
        }
    }
    Trie root = new Trie();
    public void insert(String word) {
        Trie current = root;
        for (char c: word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new Trie();
            }
            current = current.children[index];
        }
        current.isEnd = word;
    }
    public void backtrack(char[][] board, Trie current, int i, int j, List<String> answer) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0) {
            return;
        }

        char prev = board[i][j];
        if (prev == '#' || current.children[prev - 'a'] == null) return;

        current = current.children[prev - 'a'];
        if (current.isEnd != null) {
            answer.add(current.isEnd);
            current.isEnd = null;
        }
      
        board[i][j] = '#';
        backtrack(board, current, i + 1, j, answer);
        backtrack(board, current, i, j + 1, answer);
        backtrack(board, current, i - 1, j, answer);
        backtrack(board, current, i, j - 1, answer);
        board[i][j] = prev;

    }
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        for (String word: words) {
            insert(word);
        }
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                backtrack(board, root, i, j, answer);
            }
        }

        return answer;
    }
}