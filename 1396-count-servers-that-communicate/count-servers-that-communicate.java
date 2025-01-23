class Solution {
    public int countServers(int[][] grid) {
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowMap.put(i, rowMap.getOrDefault(i, 0) + 1);
                    colMap.put(j, colMap.getOrDefault(j, 0) + 1);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (rowMap.getOrDefault(i, 0) > 1|| colMap.getOrDefault(j, 0) > 1) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}

/*
 m * n
 1 means server 
 0 means no server
 two servers communicate if they are are on the same row or column.
*/