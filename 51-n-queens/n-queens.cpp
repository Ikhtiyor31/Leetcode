class Solution {
public:
    void backtrack(vector<string>& board, int row, int col, int n,  vector<vector<string>> & answer) {
        if (row == n) {
            answer.push_back(board);
            return;
        }

      
        for (int i = 0; i < n; i++) {
            if (isValid(board, row, i, n)) {
                board[row][i] = 'Q';
                backtrack(board, row + 1, n, n, answer);
                board[row][i] = '.';
            }
        }

    }

    bool isValid(vector<string>& board, int row, int col, int n) {
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // check upper diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                cout << board[i][j] << " d " << i << " " << j << "\n";
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> answer;

        for (int i = 0; i < n; i++) {
            vector<string> board(n, string(n, '.'));
            board[0][i] = 'Q';
            backtrack(board, 1, 0, n, answer);
        }

        return answer;
    }
};