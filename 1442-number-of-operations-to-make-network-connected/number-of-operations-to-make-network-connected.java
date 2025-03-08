class Solution {
    class DSU {
        int[] parent;
        int[] size;
        public DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (x == parent[x]) {
                return x;
            }

            return find(parent[x]);
        }

        public void combine(int x, int y) {
            x = find(x);
            y = find(y);
            if (x != y) {
                if (size[x] < size[y]) {
                    parent[x] = y;
                    size[y] += size[x];
                } else {
                    parent[y] = x;
                    size[x] += size[y];
                }
              
            }

        }

        public int getSize(int x) {
            int root = find(x);
            return size[root];
        }
    }


    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        DSU dsu = new DSU(n);
        int[] answer = new int[1];
        int operation = 0;
        for (int[] connection: connections) {
            dsu.combine(connection[0], connection[1]);
        }
        
        for (int i = 0; i < n; i++) {
            if (dsu.find(i) == i) {
                operation++;
            }
        }

        return operation - 1;
    }


}