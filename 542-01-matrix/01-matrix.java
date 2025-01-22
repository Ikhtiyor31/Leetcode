class Solution {
    public int[][] updateMatrix(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] directions = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 0) {
                    isWater[i][j] = 0;
                    queue.add(new int[]{i, j});
                    visited.add(i + "," + j);
                }
            }
        }
      
        
       while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            //System.out.println(Arrays.toString(pair));
            int x = pair[0];
            int y = pair[1];
            for (int[] dir: directions) {
                int r = dir[0];
                int c = dir[1];
                int xr = x + r;
                int yc = y + c;
                if (xr < m && yc < n && xr >= 0 && yc >= 0 && !visited.contains(xr + "," + yc)) {
                    isWater[xr][yc] = isWater[x][y] + 1;
                    queue.add(new int[]{x+r, y+c});
                    visited.add(xr + "," + yc);
                }
            }
       }

       return isWater;
    }
}