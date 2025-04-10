class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge: edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        int completeComponent = 0;
        for (int vertex = 0; vertex < n; vertex++) {
            if (!visited.contains(vertex)) {
                int[] componentInfo = new int[2];
                dfs(graph, vertex, visited, componentInfo);
                if (componentInfo[0] * (componentInfo[0]-1) == componentInfo[1])
                    completeComponent++;
            }
        }

        return completeComponent;
    }

    public void dfs(List<Integer>[] graph, int node, Set<Integer> visited, int[] componentInfo) {
        if (visited.contains(node)) {
            return;
        }
        componentInfo[0]++;
        componentInfo[1] += graph[node].size();
        visited.add(node);

        for (int children: graph[node]) {
            dfs(graph, children, visited, componentInfo);
        }
    }
}