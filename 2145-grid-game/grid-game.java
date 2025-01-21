class Solution {
    public long gridGame(int[][] grid) {
        
        int n = grid[0].length;
        long minimumSum = Long.MAX_VALUE;
        /*for (int i = 0; i < n; i++) {
            long bottomSum = 0;
            for (int j = 0; j < i; j++) {
                bottomSum += grid[1][j];
            }
            long topSum = 0;
            for (int j = i + 1; j < n; j++) {
                topSum += grid[0][j];
                System.out.print(grid[0][i]);
            }
            //System.out.println(topSum + " " + bottomSum);
            minimumSum = Math.min(minimumSum, Math.max(bottomSum, topSum));
        } */
        long bottomSum = 0;
        long topSum = 0;
        for (int j = 0; j < n; j++) {
            topSum += grid[0][j];
        } 
        for (int j = 0; j < n; j++) {
            topSum -= grid[0][j];
            minimumSum = Math.min(minimumSum, Math.max(bottomSum, topSum));
            bottomSum += grid[1][j];
        } 

        return minimumSum;
    }
}