class Solution {
    int[][] memo = new int[101][101];
    public int uniquePaths(int m, int n) {
        
        if (m <= 0 || n <= 0) {
            return 0;
        }
        if (memo[m][n] != 0) {
            return memo[m][n];
        }
        if (m == 1 && n == 1) {
            return 1;
        }

        return memo[m][n] = uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }
}