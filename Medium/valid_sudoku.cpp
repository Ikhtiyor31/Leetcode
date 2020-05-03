class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
            
            int n = 9; 
            int index_row= 0, index_col = 0;
            int digit = 0;
            for(int i = 0; i < n; i++) {
                    set<int> st;
                    
                    // check horizontally 
                    for(int j  = 0; j < n; j++) {
                            if(board[i][j] != '.') {
                                      digit = (int)(board[i][j] - '0');
                                    if(st.find(digit) == st.end())  {
                                            st.insert(digit);
                                    }else {
                                            return false;
                                    }
                                    
                            }
                    }      
                      st.clear();
                      digit = 0;
                    
                       // check vertically 
                      for(int j = 0; j < n; j++) {
                              if(board[j][i] != '.') {
                                      digit = (int)(board[j][i] - '0');
                                      
                                      if(st.find(digit) == st.end()) {
                                              st.insert(digit);
                                      }else {
                                              return false;
                                      }
                              }
                              
                      }
                    st.clear();
                    digit = 0;
                   
                    
                        for(int i = 0; i < 3; i++) {
                                for(int  j = 0; j < 3; j++) {
                                        
                                        if(board[i+index_row][j+index_col] != '.') {
                                              digit = (int)(board[i+index_row][j+index_col] - '0');
                                       
                                              if(st.find(digit) == st.end()) {
                                                      st.insert(digit);
                                              }else {
                                                     
                                                      return false;
                                              }
                                        }
                                }
                        }
                    
                    if(i == 2 || i == 5) {
                            index_col = 0;
                            index_row += 3;
                    } else {
                            index_col += 3;
                    }
                    
                    st.clear();
                    digit = 0;
                    
            }
            
            return true;
    }
};
