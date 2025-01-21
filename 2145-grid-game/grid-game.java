class Solution {
    public long gridGame(int[][] grid) {
        long topSum = 0;
        for (int num: grid[0]) {
            topSum += num;
        }
        long bottomSum = 0;
        long minimumSum = Long.MAX_VALUE;

        for (int i = 0; i < grid[0].length; i++) {
            topSum -= grid[0][i];
            minimumSum = Math.min(minimumSum, Math.max(topSum, bottomSum));
            bottomSum += grid[1][i];
        }

        return minimumSum;
    }
}