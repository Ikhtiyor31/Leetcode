class Solution {
    
public:
  
    bool isIsomorphic(string s, string t) {
        if(s.size() != t.size()) return false;
        if(s.empty() && t.empty())
            return true;
        unordered_map<char, char> st;
        unordered_map<char, char> ts;
        for(int i = 0; i  < s.size(); i++) {
            if(st.count(s[i]) && !ts.count(t[i]) || !st.count(s[i]) && ts.count(t[i])) {
                return false;
            }
            if(st.count(s[i])) {
                if(st[s[i]] != t[i] || ts[t[i]] != s[i]) return false;
            }
             else {
                 st.insert({s[i], t[i]});
                 ts.insert({t[i], s[i]});
             }
        }
        
        return true;
    }
};
