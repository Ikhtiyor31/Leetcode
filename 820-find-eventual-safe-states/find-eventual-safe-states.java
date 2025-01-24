class Solution {
    public boolean dfs(int[][] graph, int node, int[] visited) {

        if (visited[node] != 0) {
            return visited[node] == 1;
        }

        visited[node] = 2;

        for (int path: graph[node]) {
            if (!dfs(graph, path, visited)) {
                return false;
            }
        }

        visited[node] = 1;

        return true;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> safeNodes = new ArrayList<>();
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (dfs(graph, i, visited)) {
                 safeNodes.add(i);
            }
            
        }

        return safeNodes;

    }
}

/*
 0 -> 1, 2
 1 -> 2, 3
 2 -> 5
 3 -> 0
 4 -> 5
 5 -> [] -> meaning there are no outgoing edges.
 6 -> [] -> meaning there are no outgoing edges.

 0 -> 1, 2, 3, 4
 1 -> 1, 2
 2 -> 3, 4
 3 -> 0, 4
 4 -> []

 0 -> []
 1 -> 0, 2, 3, 4
 2 -> 3
 3 -> 4
 4 -> []

0 -> []
1 -> 2
2 -> 3, 4
3 -> 4
4 -> []
*/