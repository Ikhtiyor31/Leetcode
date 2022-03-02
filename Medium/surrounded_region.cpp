/*130. Surrounded Regions
[https://leetcode.com/problems/surrounded-regions] */
class Solution {
public:
    bool dfs(vector<vector<char>> & board, int i, int j, set<pair<int, int>> & pst) {
        if (i >= board.size()  i < 0  j >= board[0].size() || j < 0) {
            return false;
        }
    
        if (board[i][j] == 'X') return true;
        //cout << i << " and " << j << "\n";
        if (pst.count({i, j})) return true;
        pst.insert({i, j});
        return dfs(board, i - 1, j, pst) &&
        dfs(board, i, j - 1, pst) && 
        dfs(board, i + 1, j, pst) && 
        dfs(board, i, j + 1, pst);
    }
    void dfs2(vector<vector<char>> & board, int i, int j, set<pair<int, int>> & pst) {
        if (i >= board.size()  i < 0  j >= board[0].size() || j < 0) {
            return;
        }
        
        if (board[i][j] == 'X') return;
        if (pst.count({i, j})) return;
        pst.insert({i, j});
        board[i][j] = 'X';
        dfs2(board, i - 1, j, pst);
        dfs2(board, i, j - 1, pst);
        dfs2(board, i + 1, j, pst);
        dfs2(board, i, j + 1, pst);
        
    }
    void solve(vector<vector<char>>& board) {
        int n = board.size();
        int m = board[0].size();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    set<pair<int, int>> pst;
                    if (dfs(board, i, j, pst) == true) {
                        set<pair<int, int>> pst2;
                       dfs2(board, i, j, pst2);
                    }
                    
                }
            }
        }
    }
};
