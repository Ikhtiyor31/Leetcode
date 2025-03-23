class Solution {

    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length;
        int n = moveTime[0].length;
        int answer = Integer.MAX_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{0, 0, 0});
        int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0,-1}};
        Set<String> visited = new HashSet<>();
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            System.out.println(Arrays.toString(curr));
            if (curr[0] == m - 1 && curr[1] == n - 1) {
                return curr[2];
            }
            for (int[] dir: directions) {
                int newr = curr[0] + dir[0];
                int newc = curr[1] + dir[1];
                String key = newr + "," + newc; 
                if (newr < m && newr >= 0 && newc < n && newc >= 0 && !visited.contains(key)) {
                    pq.add(new int[]{newr, newc, Math.max(curr[2], moveTime[newr][newc]) + 1});
                    visited.add(key);
                }
            }
        }

        return answer;

    }
}