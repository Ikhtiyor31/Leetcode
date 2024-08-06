class neighborSum {
    Map<Integer, Pair<Integer, Integer>> map = new HashMap<>();
    private int n;
    private int[][] grid;
    public neighborSum(int[][] grid) {
        n = grid.length;
        this.grid = grid;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map.put(grid[i][j], new Pair<>(i, j));
            }
        }
    }
    
    public int adjacentSum(int value) {
        int[] dirX = {-1, 0, 0, 1};
        int[] dirY = {0, 1, -1, 0};
        Pair<Integer, Integer> pair = map.get(value);
        int x = pair.getKey();
        int y = pair.getValue();
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            int row = x + dirX[i];
            int col = y + dirY[i];
            if (insideBorder(row, col)) {
                sum += grid[row][col];
            }
        }
        return sum;
    }
    
    public int diagonalSum(int value) {
        int[] dirX = {-1, -1, 1, 1};
        int[] dirY = {-1, 1, 1, -1};
        Pair<Integer, Integer> pair = map.get(value);
        int x = pair.getKey();
        int y = pair.getValue();
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            int row = x + dirX[i];
            int col = y + dirY[i];
            if (insideBorder(row, col)) {
                sum += grid[row][col];
            }
        }
        return sum;
    }

    private boolean insideBorder(int x, int y) {
        if (x >= n || x < 0 || y >= n || y < 0) {
            return false;
        }

        return true;
    }
}

/**
 * Your neighborSum object will be instantiated and called as such:
 * neighborSum obj = new neighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */