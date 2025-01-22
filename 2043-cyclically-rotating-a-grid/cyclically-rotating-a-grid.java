class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < Math.min(m, n) / 2; i++) {
            List<Integer> temp = new ArrayList<>();

            // Collect top row (left to right)
            for (int j = i; j < n - i; j++) {
                temp.add(grid[i][j]);
            }

            // Collect right column (top to bottom)
            for (int r = i + 1; r < m - i - 1; r++) {
                temp.add(grid[r][n - i - 1]);
            }

            // Collect bottom row (right to left)
            for (int j = n - i - 1; j >= i; j--) {
                temp.add(grid[m - i - 1][j]);
            }

            // Collect left column (bottom to top)
            for (int r = m - i - 2; r > i; r--) {
                temp.add(grid[r][i]);
            }

            // Rotate the collected elements by k positions
            int rotateBy = k % temp.size(); // Avoid unnecessary full rotations
            Collections.rotate(temp, -rotateBy);

            // Place back the rotated elements
            int index = 0;

            // Place top row (left to right)
            for (int j = i; j < n - i; j++) {
                grid[i][j] = temp.get(index++);
            }

            // Place right column (top to bottom)
            for (int r = i + 1; r < m - i - 1; r++) {
                grid[r][n - i - 1] = temp.get(index++);
            }

            // Place bottom row (right to left)
            for (int j = n - i - 1; j >= i; j--) {
                grid[m - i - 1][j] = temp.get(index++);
            }

            // Place left column (bottom to top)
            for (int r = m - i - 2; r > i; r--) {
                grid[r][i] = temp.get(index++);
            }
        }

        return grid;
    }
}