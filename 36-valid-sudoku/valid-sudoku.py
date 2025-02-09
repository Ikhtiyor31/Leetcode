class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        for i in range(0, 9):
            row_seen = {}
            col_seen = {}
            for j in range(0, 9):
                if (board[j][i] != '.' and board[j][i] in row_seen) or (board[i][j] != '.' and board[i][j] in col_seen):
                    return False
                row_seen[board[j][i]] = True
                col_seen[board[i][j]] = True

        for i in range(0, 3):
            for j in range(0, 3):
                unique_subgrid = {}
                for r in range(i * 3, (i + 1) * 3):
                    for c in range(j * 3, (j + 1) * 3):
                        if board[r][c] != '.' and board[r][c] in unique_subgrid:
                            return False
                        unique_subgrid[board[r][c]] = True
        return True
    
#1. Traverse through each row and column, using dictionary to ensure that unique values exist in both
#2. Iterate through every 3x3 subgrid and check for duplicates, return False if found 
#3. Return 'True' if no duplicates are detected, stating the board is valid according to Sudoku Rule