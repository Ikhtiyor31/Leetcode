class Solution {
    int mod = 1000000007;
    public int dfs(int current, int n, int x, int[][] memo) {
        if (n == 0) return 1;
        if (current > n) return 0;
        if (memo[current][n] != -1) return memo[current][n];
        // not take 
        int leave = dfs(current + 1, n, x, memo);
        // take 
        int take = dfs(current + 1, n - (int)(Math.pow(current, x)), x, memo);

        return memo[current][n] = (leave  + take) % mod;
    }
    public int numberOfWays(int n, int x) {
        int[][] memo = new int[301][n+1];
        for (int[] row: memo) {
            Arrays.fill(row, -1);
        }
        return dfs(1, n, x, memo);

    }
}