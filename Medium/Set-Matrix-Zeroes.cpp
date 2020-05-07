class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
     int n = matrix.size(); 
     int m = matrix[0].size();
          set<int> st_row;
            set<int> st_col;
            for(int i = 0; i < n; i++) {
                    for(int j = 0; j < m; j++) {
                        if(matrix[i][j] == 0) {
                               st_row.insert(i);
                                st_col.insert(j);
                        }   
                    }
            }
           for(int x: st_row) {
                   fill(matrix[x].begin(), matrix[x].end(), 0);
                   
           }
           
           
             for(int i = 0; i < m; i++) {
                 
                   if(st_col.find(i)  != st_col.end()) {
                          
                           for(int j = 0; j < n; j++) {
                           
                                  matrix[j][i] = 0;
                           }
                   }
           }
          
          
    }
};
