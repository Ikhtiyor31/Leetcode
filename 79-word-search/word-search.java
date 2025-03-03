class Solution {
    public boolean backtrack(char[][] board, String word, int i, int j, int index) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0) {
            return false;
        }

        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        if (index == word.length() - 1) {
            return true;
        }

       

     
        char prev = board[i][j];
        board[i][j] = '#';
        boolean result = false;
        result |= backtrack(board, word, i + 1, j, index + 1);
        result |= backtrack(board, word, i, j + 1, index + 1);
        result |= backtrack(board, word, i - 1, j, index + 1);
        result |= backtrack(board, word, i, j - 1, index + 1);
        board[i][j] = prev;

        return result;
    }
    public boolean exist(char[][] board, String word) {
        
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    //System.out.println(board[i][j]);
                    if (backtrack(board, word, i, j, 0)) return true;
                }
            }
        }

        return false;
    }
}