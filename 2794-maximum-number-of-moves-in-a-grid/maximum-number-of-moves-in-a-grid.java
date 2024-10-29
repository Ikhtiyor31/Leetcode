class Solution {

    public int dfs(int[][] grid, int i, int j, int[][] memo) {
        if (i < 0 || j < 0 || j >= grid[0].length || i >= grid.length) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int count1 = 0, count2 = 0, count3 = 0;
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (i > 0 && j < m - 1 && grid[i][j] < grid[i - 1][j + 1]) {
            count1 = dfs(grid, i - 1, j + 1, memo) + 1;
        }
        if (j < m - 1 && grid[i][j] < grid[i][j + 1]) {
            count2 = dfs(grid, i, j + 1, memo) + 1;
        }
        if (i < n - 1 && j < m - 1 && grid[i][j] < grid[i + 1][j + 1]) {
            count3 = dfs(grid, i + 1, j + 1, memo) + 1;
        }
        memo[i][j] = Math.max(count3, Math.max(count1, count2));
        return memo[i][j];
    }
    public int maxMoves(int[][] grid) {
        int maxMove = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] memo = new int[n][m];
        for (int[] row : memo) {
            Arrays.fill(row, -1); 
        }
        for (int i = 0; i < n; i++) {
            maxMove = Math.max(maxMove, dfs(grid, i, 0, memo));
        }

        return maxMove;

    }
}