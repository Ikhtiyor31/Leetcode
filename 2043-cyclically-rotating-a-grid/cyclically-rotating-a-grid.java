class Solution {

    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < Math.min(n, m) / 2; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = i; j < n - i; j++) {
                // System.out.print(grid[i][j] + " ");
                temp.add(grid[i][j]);
            }

            for (int r = i + 1; r < m - i - 1; r++) {
                // System.out.print(grid[r][n-i-1] + " ");
                temp.add(grid[r][n - i - 1]);
            }

            for (int j = i; j < n - i; j++) {
                // System.out.print(grid[m-i-1][n-j-1] + " ");
                temp.add(grid[m - i - 1][n - j - 1]);
            }

            for (int r = i + 1; r < m - i - 1; r++) {
                // System.out.print(grid[m-r-1][i] + " ");
                temp.add(grid[m - r - 1][i]);
            }

            if (temp.size() > 0) {
                //System.out.println(temp);
       
                Collections.rotate(temp, temp.size() - k);
                //System.out.println(temp);
                int c = 0;
                for (int j = i; j < n - i; j++) {
                    grid[i][j] = temp.get(c++);
                }

                for (int r = i + 1; r < m - i - 1; r++) {
                    grid[r][n - i - 1] = temp.get(c++);
                }

                for (int j = i; j < n - i; j++) {
                    grid[m - i - 1][n - j - 1] = temp.get(c++);
                }

                for (int r = i + 1; r < m - i - 1; r++) {
                    grid[m - r - 1][i] = temp.get(c++);
                }
            }

        }

        return grid;
    }
}