class Solution {
public:
    vector<string> subdomainVisits(vector<string>& cpdomains) {
            vector<string> num;
            stringstream sep;
            string take;
            unordered_map<string, int> umap;
            for(string str: cpdomains) {
                stringstream ss;
                string num;
                ss << str;
                ss >> num;
                string plus;
                for(int i = str.size()-1; i >= 0; i--)  {
                    if(str[i] == ' ') {
                         
                        umap[plus] += stoi(num);
                        break;
                    }
                    if(str[i] != '.') {
                       plus = str[i] + plus; 
                    } else {
                       
                        umap[plus] += stoi(num);
                        plus  = str[i] + plus;
                    }
                }
            }
        vector<string> ans;
          for(auto go = begin(umap); go != end(umap); go++) {
               string curr;
               curr = to_string(go->second) + " " + (go->first);
              ans.push_back(curr);
          }  
        return ans;
    }
};
