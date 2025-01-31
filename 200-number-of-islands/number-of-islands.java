class Solution {
    public void dfs(char[][] grid, int i, int j, Set<String> visited) {
        String pair = i+","+j;
        if (i >= grid.length || i < 0 || j >= grid[i].length || j < 0 || visited.contains(pair)) {
            return;
        }

        visited.add(pair);

        if (grid[i][j] == '0') {
            return;
        }

        dfs(grid, i + 1, j, visited);
        dfs(grid, i, j + 1, visited);
        dfs(grid, i - 1, j, visited);
        dfs(grid, i, j - 1, visited);
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited.contains(i+","+j) && grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, visited);
                }
            }
        }

        return count;
    }
}