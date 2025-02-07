class Solution {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<List<Integer>>> adj = new HashMap<>();
        for (int[] connection : connections) {
            adj.computeIfAbsent(connection[0], k -> new ArrayList<List<Integer>>())
                    .add(Arrays.asList(connection[1], 1));
            adj.computeIfAbsent(connection[1], k -> new ArrayList<List<Integer>>())
                    .add(Arrays.asList(connection[0], 0));
        }

        boolean[] visited = new boolean[n];
        visited[0] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            if (!adj.containsKey(node)) {
                continue;
            }

            for (List<Integer> list : adj.get(node)) {
                if (!visited[list.get(0)]) {
                    count += list.get(1);
                    visited[list.get(0)] = true;
                    q.offer(list.get(0));
                }
            }
        }

        return count;

    }
}