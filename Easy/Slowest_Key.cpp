class Solution {
     static bool comp(const pair<char, int> &p1, const pair<char, int> &p2)  {
           return p1.second == p2.second ? p1.first > p2.first : p1.second > p2.second;
    }
public:
    char slowestKey(vector<int>& releaseTimes, string keysPressed) {
        vector<pair<char, int>> ans;
        int n = releaseTimes.size();
        for(int i = 1; i < n; i++) {
            if(i-1== 0) {
                ans.push_back({keysPressed[i-1], releaseTimes[i-1]});
            }
               ans.push_back({keysPressed[i], releaseTimes[i]-releaseTimes[i-1]});   
        }
        
        sort(ans.begin(), ans.end(), comp);
       
        return ans[0].first;
    }
};
