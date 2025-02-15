class Solution {
    public int dfs(int[][] grid, int i, int j, int islandId) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = islandId;
        return (1 + dfs(grid, i + 1, j, islandId) + dfs(grid, i, j + 1, islandId) + dfs(grid, i - 1, j, islandId) + dfs(grid, i, j - 1, islandId));

    }
    public boolean outOfBorders(int[][] grid, int i, int j) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0) {
            return true;
        }

        return false;
    }
    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int largestIsland = 0;
        int islandId = 2;
        Map<Integer, Integer> islandSizes = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int count = dfs(grid, i, j, islandId);
                    islandSizes.put(islandId, count);
                    islandId += 1;
                }
            }
        }
        System.out.println(Arrays.deepToString(grid));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    HashSet<Integer> uniqueNeighboringIslands = new HashSet<>();
                    int currentIslandSize = 1;
                    int[][] directions = {{i + 1, j}, {i, j + 1}, {i - 1, j}, {i, j - 1}};
                    for (int[] path: directions) {
                        if (!outOfBorders(grid, path[0], path[1]) && !uniqueNeighboringIslands.contains(grid[path[0]][path[1]]) && islandSizes.containsKey(grid[path[0]][path[1]])) {
                            System.out.println(grid[path[0]][path[1]]);
                            currentIslandSize += islandSizes.get(grid[path[0]][path[1]]);
                            uniqueNeighboringIslands.add(grid[path[0]][path[1]]);
                        }
                    }
                  
                    largestIsland = Math.max(largestIsland, currentIslandSize);
                }
            }
        }
        return largestIsland == 0 ? n * m : largestIsland;
    }
}

/*
 * 1, 1
 * 1, 0
 * 
 * 
 */