class Solution {
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{0, 0, grid[0][0]});
         int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0,-1}};
        Set<String> visited = new HashSet<>();
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            //System.out.println(curr[2]);
            if (curr[0] == m - 1 && curr[1] == n - 1) {
                return curr[2];
            }
            for (int[] dir: directions) {
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];
                String key = r + "," + c;
                if (r < m && r >= 0 && c < n && c >= 0 && !visited.contains(key)) {
                    int newTime =  Math.max(grid[r][c], curr[2] + 1);
                    if (newTime % 2 != (curr[2] + 1) % 2)
                        newTime++;
                    pq.offer(new int[]{r, c, newTime});
                    visited.add(key);
                }
            }
        }

        return -1;
    }
}