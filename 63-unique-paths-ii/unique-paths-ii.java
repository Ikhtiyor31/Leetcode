class Solution {
    int[][] memo;
    public int uniquePathsWithObstacles(int[][] obstacleGrid, int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        if (m == 0 && n == 0 && obstacleGrid[m][n] == 0) {
            return 1;
        }

        if (obstacleGrid[m][n] == 1) {
            return 0;
        }

        return memo[m][n] = uniquePathsWithObstacles(obstacleGrid, m - 1, n) + uniquePathsWithObstacles(obstacleGrid, m, n - 1);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        memo = new int[m][n];
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        return uniquePathsWithObstacles(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1);
    }
}