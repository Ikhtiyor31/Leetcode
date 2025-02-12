class Solution {
    public int[] startSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    return new int[]{r, c};
                }
            }
        }

        return new int[]{-1, -1};
    }

    int answer;
    int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public void dfs(int[][] grid, int r, int c, int target, int count) {
        if (r >= grid.length || r < 0 || c >= grid[0].length || c < 0 || grid[r][c] == -1) {
            return;
        }

        //System.out.println(grid[r][c] + " " + count);
        if (grid[r][c] == 2 && count == target + 1) {
            answer++;
        }
        int prev = grid[r][c];
        grid[r][c] = -1;

        for (int[] direction: directions) {
            int new_r = r + direction[0];
            int new_c = c + direction[1];
            dfs(grid, new_r, new_c, target, count + 1);
        }

        grid[r][c] = prev;

    }
    public int countObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int obstacles = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -1) {
                    obstacles++;
                }
            }
        }

        return obstacles;
    }
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        answer = 0;
        int[] start = startSquare(grid);
        int obstacles = countObstacles(grid);
        int target = (m * n ) - obstacles - 2;
        dfs(grid, start[0], start[1], target, 0);
        
        
        return answer;
    }
}