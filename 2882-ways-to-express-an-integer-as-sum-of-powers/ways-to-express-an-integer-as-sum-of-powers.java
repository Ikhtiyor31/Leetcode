class Solution {
    private final int mod = 1000000007;

    public int numberOfWays(int start, int n, int x, int[][] memo) {
        if (n == 0) {
            return 1;
        }

        if (start > n) {
            return 0;
        }
        if (memo[start][n] != -1) {
            return memo[start][n];
        }


        // not take
        int notTake = numberOfWays(start + 1, n, x, memo);
        // take
        int sum = (int) Math.pow(start, x);
        int take = numberOfWays(start + 1, n - sum, x, memo);

        return memo[start][n] = (take + notTake) % mod;
    }

    public int numberOfWays(int n, int x) {
        int[][] memo = new int[301][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return numberOfWays(1, n, x, memo) % mod;
    }
}