class Solution {
    public int dfs(boolean[] visited, Map<Integer, List<List<Integer>>> adj, int node) {
        if (visited[node]) {
            return 0;
        }
        visited[node] = true;
        int count = 0;
        for (List<Integer> list: adj.get(node)) {
            if (!visited[list.get(0)]) {
                count += list.get(1);
                count += dfs(visited, adj, list.get(0));
            }
        }

        return count;
    }
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<List<Integer>>> adj = new HashMap<>();

        for (int[] connection: connections) {
            adj.computeIfAbsent(connection[0], k -> new ArrayList<List<Integer>>()).add(Arrays.asList(connection[1], 1));
            adj.computeIfAbsent(connection[1], k -> new ArrayList<List<Integer>>()).add(Arrays.asList(connection[0], 0));
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count += dfs(visited, adj, i);
            }
        }

        return count;

    }
}