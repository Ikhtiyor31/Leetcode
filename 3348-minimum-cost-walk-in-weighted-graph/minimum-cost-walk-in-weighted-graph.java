class Solution {
    class DSU {
        private int[] parent;
        private int[] rank;

        public DSU(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                this.parent[i] = -1;
            }
            rank = new int[n];
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }

        public int find(int node) {
            if (parent[node] == -1)
                return node;
            return parent[node] = find(parent[node]);
        }

        public void union(int x, int y) {
            int root1 = find(x);
            int root2 = find(y);
            if (root1 == root2)
                return;

            if (rank[root1] < rank[root2]) {
                int temp = root1;
                root1 = root2;
                root2 = temp;
            }

            parent[root2] = root1;
            if (rank[root1] == rank[root2]) {
                rank[root1]++;
            }
        }
    }

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int[] componentCost = new int[n];
        for (int i = 0; i < n; i++) {
            componentCost[i] = Integer.MAX_VALUE;
        }
        DSU dsu = new DSU(n);
        // Construct the connected components of the graph
        for (int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }

        for (int[] edge : edges) {
            int root = dsu.find(edge[0]);
            componentCost[root] &= edge[2];
        }
        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int start = query[i][0];
            int end = query[i][1];
            if (dsu.find(start) != dsu.find(end)) {
                answer[i] = -1;
            } else {
                int root = dsu.find(start);
                answer[i] = componentCost[root];
            }
        }
        return answer;
    }

}