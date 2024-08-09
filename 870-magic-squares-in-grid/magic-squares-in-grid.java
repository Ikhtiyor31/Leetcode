class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int[][] dir = {{0, 1}, {0, -1}, {-1, 1}, {1, -1}, {-1, 0}, {1, 0}, {-1, -1}, {1, 1}};
        int[][] borderDir = {{1, 1}, {0, 1}, {-1, 1}, 
                             {-1, 1}, {-1, 0}, {-1, -1},
                             {-1, -1}, {0, -1}, {1, -1},
                             {1, -1}, {1, 0}, {1, 1}};
        int count = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length - 1; j++) {
                Set<Integer> sum = new HashSet<>();
                Set<Integer> distinct = new HashSet<>();
                int current = grid[i][j];
                distinct.add(current);
                for (int k = 0; k < 8; k += 2) {
                    int x1 = i + dir[k][0];
                    int y1 = j + dir[k][1];

                    int x2 = i + dir[k + 1][0];
                    int y2 = j + dir[k + 1][1];
                    int currentSum = current + grid[x1][y1] + grid[x2][y2];
                    sum.add(currentSum);
                    distinct.add(grid[x1][y1]);
                    distinct.add(grid[x2][y2]);

                }

                // only border sums 
                for (int k = 0; k < 12; k += 3) {
                    int i1 = i + borderDir[k][0];
                    int j1 = j + borderDir[k][1];
                    int i2 = i + borderDir[k + 1][0];
                    int j2 = j + borderDir[k + 1][1];
                    int i3 = i + borderDir[k + 2][0];
                    int j3 = j + borderDir[k + 2][1];
                    int currentSum = grid[i1][j1] + grid[i2][j2] + grid[i3][j3];
                    sum.add(currentSum);
                    //System.out.println("{" + i1 + " " + j1 + "} : {" + i2 + " " + j2 + "} : {" + i3 + " " + j3 + "}");
                }
                //System.out.println(sum.size());
                if (sum.size() == 1 && distinct.size() == 9) {
                    int c = 0;
                    for (int num: distinct) {
                        if (num > 0 && num <= 9) {
                            c++;
                        }
                    }
                    if (c == 9) {
                      count++;
                    }
                }
                
            }

        }

        return count;
    }
}

// [[10, 3, 5],
//  [1, 6, 11],
//  [7, 9, 2]]