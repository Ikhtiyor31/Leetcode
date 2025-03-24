class Solution {
    int mod = 1_000_000_007;
    int dfs2(List<Pair<Integer, Integer>>[] adj, int src, int dest, long[] distances, Set<Integer> visited) {
        if (src == dest) {
            return 1; // Found a path
        }
        visited.add(src);
        int count = 0;
        for (Pair<Integer, Integer> pair : adj[src]) {
            int v = pair.getKey();
            long weight = pair.getValue();
            if (!visited.contains(v) && distances[src] + weight == distances[v]) {
                count = (count + dfs2(adj, v, dest, distances, visited)) % mod;
            }
        }
        visited.remove(src); // Backtrack
        return count;
    }

    public int countPaths(int n, int[][] roads) {
        List<Pair<Integer, Integer>>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int time = roads[i][2];
            adj[u].add(new Pair<>(v, time));
            adj[v].add(new Pair<>(u, time));
        }
        int src = 0;
        int dest = n - 1;
        long[] distances = new long[n];
        Arrays.fill(distances, Long.MAX_VALUE);
        distances[src] = 0;
        Queue<Pair<Integer, Long>> heap = new PriorityQueue<>(Comparator.comparing(Pair::getValue));
        heap.offer(new Pair<>(src, 0L));
        while (!heap.isEmpty()) {
            Pair<Integer, Long> curr = heap.poll();
            int u = (int) curr.getKey();
            long currWeight = curr.getValue();
            for (Pair<Integer, Integer> pair : adj[u]) {
                int v =  pair.getKey();
                long weight = pair.getValue();
                if (distances[u] + weight < distances[v]) {
                    distances[v] = distances[u] + weight;
                    heap.offer(new Pair<>(v, distances[v]));
                }
            }
        }

        int[] dp = new int[n];
        dp[src] = 1; // There is 1 way to reach the source
        int numberOfPaths = 0;
        Integer[] nodes = new Integer[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = i;
        }
        Arrays.sort(nodes, Comparator.comparingLong(a -> distances[a]));


        for (int node : nodes) {
            for (Pair<Integer, Integer> pair : adj[node]) {
                if (distances[node] + pair.getValue() == distances[pair.getKey()]) {
                    dp[pair.getKey()] =  (dp[node] + dp[pair.getKey()]) % mod;
                }
            }
        }
        return dp[dest];
    }
}