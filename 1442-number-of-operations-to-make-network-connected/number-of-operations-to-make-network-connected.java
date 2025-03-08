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

        public void combine(int x, int y, int[] answer) {
            x = find(x);
            y = find(y);
            if (x != y) {
                answer[0] -= 1;
                
                    parent[x] = y;
                    size[y] += size[x];
                
              
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
        answer[0] = n;
        for (int[] connection: connections) {
            dsu.combine(connection[0], connection[1], answer);
        }
        

        return answer[0] - 1;
    }


}