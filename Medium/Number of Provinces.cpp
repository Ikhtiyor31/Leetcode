class Solution {
public:
    int find(int x, vector<int> & root) {
        return root[x];
    }

    void unionSet(int x, int y, vector<int> &root) {
        int rootX = find(x, root);
        int rootY = find(y, root);
        
        if(rootX != rootY) {
            for(int i = 0; i < root.size(); i++) {
                if (root[i] == rootY) {
                    root[i] = rootX;
                }
            }
        }
    }
    int findCircleNum(vector<vector<int>>& isConnected) {
        
        int n = isConnected.size();
        vector<int> root(n);
        for(int i = 0; i< n; i++) {
            root[i] = i;
        }
        
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    unionSet(i, j, root);
                }
            }
        }
        set<int> st;
        for(int i = 0; i < n; i++) {
            st.insert(root[i]);
        }
        
        
        return st.size();
    }
};
