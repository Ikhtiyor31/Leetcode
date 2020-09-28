class Solution {
     vector<vector<string>> ans;
public:
    void dfs(string& bw, string &ew, vector<string> &path, unordered_map<string, unordered_set<string>> &adj) {
        path.push_back(bw);
        if(bw == ew) {
            
            ans.push_back(path);
            path.pop_back();
            return;
        }
       for(auto x : adj[bw]) {
           dfs(x, ew, path, adj);
       }
      path.pop_back();
    }
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
          unordered_map<string, unordered_set<string>> adj; // adjacency list
          unordered_set<string> dict(wordList.begin(), wordList.end()); // insert wordList into set
          // bfs 
          queue<string> q; 
          q.push(beginWord);
          unordered_map<string, int> visited;
          visited[beginWord] =  0;
          while(!q.empty()) {
              string take = q.front();
              q.pop();
              string temp = take;
              for(int i = 0; i  < take.size(); i++) {
                  for(char ch = 'a'; ch <= 'z'; ch++) {
                      if(temp[i] == ch)
                          continue;
                      temp[i] = ch;
                      if(dict.count(temp)) {
                          
                          if(!visited.count(temp)) {
                              visited[temp] = visited[take] + 1;
                              q.push(temp);
                              adj[take].insert(temp);
                          }
                          else if(visited[temp] == visited[take] + 1) //If already visited and new word is the child (We should always move down)
                              adj[take].insert(temp);
                          
                      }
                  }
                  temp[i] = take[i]; // revsert back 
              }
          }
        // debugging 
          /*for(auto it = begin(adj); it != end(adj); it++) {
               cout << it->first << " --> ";
              for(string x : it->second) {
                  cout << x << " ";
              }
              cout << "\n";
          } */
        //   Find all possible paths at min-depth using DFS
        vector<string> path;
      dfs(beginWord, endWord, path, adj);
        return ans;
    }
};
