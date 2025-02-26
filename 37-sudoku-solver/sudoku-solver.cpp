class Solution {
public:
    bool outBound(vector<vector<char>> & board, int i, int j) {
        return i >= board.size() || i < 0 || j >= board[0].size() || j < 0;
    }
    bool backtrack(vector<vector<char>>& board, int i, int j) {
        if (i == 9) {
            return true;
        }

        if (j == 9) {
            return backtrack(board, i + 1, 0);
        }

        if (board[i][j] != '.') {
            return backtrack(board, i, j + 1);
        }

        for (char num = '1'; num <= '9'; num++) {
            if (isValid(board, i, j, num)) {
                board[i][j] = num; 
                if (backtrack(board, i, j + 1)) {
                    return true;
                }
                board[i][j] = '.';
            }
           
        }

        return false;
        
    }
    void solveSudoku(vector<vector<char>>& board) {
        backtrack(board, 0, 0);
    }

    bool isValid(vector<vector<char>> & board, int i, int j, char num) {
        for (int row = 0; row < 9; row++) {
            if (board[row][j] == num) {
                return false;
            }
        }

        for (int col = 0; col < 9; col++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        int start_r = (i / 3) * 3;
        int start_c = (j / 3) * 3;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[start_r + r][start_c + c] == num) {
                    return false;
                }
            }
        }

        return true;

    }
};