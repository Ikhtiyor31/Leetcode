class Solution {
   
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0});
        int directions[][] = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        Set<String> visited = new HashSet<>();
        while (!pq.isEmpty()) {

            int[] curr = pq.poll();
            if (curr[1] == n - 1 && curr[2] == m - 1) {
                return curr[0];
            }
            System.out.println(curr[0] + " " + curr[1] + " " + curr[2]);
            for (int [] dir: directions) {
                int r = dir[0];
                int c = dir[1];
                int newRow = r + curr[1];
                int newCol = c + curr[2];
                String key = new StringBuilder(newRow + "," + newCol).toString();
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !visited.contains(key)) {
                    int maxTime = Math.max(curr[0], moveTime[newRow][newCol]) + 1;
                    pq.offer(new int[]{maxTime, newRow, newCol});
                    visited.add(key);
                }
            }
        }

        return -1;
    }
}

/* [
    [0,0,0],
    [0,0,0]
    ] 
    [
     [4, 4],
     [4, 4]
     ]
    
    [
      [0, 1],
      [1, 2]
    ]
    [
        [100, 8],
        [100, 9]
    ]
    
*/

