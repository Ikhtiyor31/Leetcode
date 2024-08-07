class Solution {
    public void dfs(int[][] isConnected, Set<Integer> visit, int node) {
        if (visit.contains(node)) {
            return;
        }

        visit.add(node);
        for (int children = 0; children < isConnected.length; children++) {
            if (isConnected[node][children] == 1) {
                dfs(isConnected, visit, children);
            }
        }
    }


    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        Set<Integer> visit = new HashSet<>();
        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (!visit.contains(i)) {
                dfs(isConnected, visit, i);
                provinces += 1;
            }
        }

        return provinces;
    }
}