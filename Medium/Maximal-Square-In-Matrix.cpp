#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
         
    int maximalSquare(vector<vector<string>>& matrix) {
           int n = matrix.size();
           if(n == 0 || matrix[0].empty()) {
                   return 0;
           } 
           int m = matrix[0].size();
            int answer = 0;
           vector<vector<int>> DP(n, vector<int> (m));
           for(int i = 0; i  < n; ++i) {
                   for(int j  = 0; j < m; j++) {
                           if(matrix[i][j] == "0") {
                                   DP[i][j] = 0;
                           }else {
                                   DP[i][j] = 1;
                                   if(i > 0 && j > 0) {
                                   DP[i][j] = 1 + min({DP[i-1][j], DP[i][j-1], DP[i-1][j-1]});
                                   }
                                   answer = max(answer, DP[i][j]);
                           }
                           
                   }
           } 
            return answer * answer;
    }
    void hello() {
      cout << " Hello world " << "\n";
    }
};

int main() {
  Solution sol;
  vector<vector<string>> array = {{"1","0","1","0","0"},{"1","0","1","1","1"},{"1","1","1","1","1"},{"1","0","0","1","0"}};
    cout <<  sol.maximalSquare(array);
  
  return 0;
}