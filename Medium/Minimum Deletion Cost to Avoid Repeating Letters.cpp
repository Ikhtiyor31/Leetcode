class Solution {
    const int maxn = 1e5+5;
public:
    int minCost(string s, vector<int>& cost) {
        int n = cost.size();
        int ans = 0;
        int min_one = maxn;
        for(int i = 1; i < n; i++) {
            if(s[i-1] == s[i]) {
                if(cost[i-1] > cost[i]) {
                    ans += cost[i];
                    swap(cost[i-1], cost[i]);
                    
                } else {
                    ans += cost[i-1];
                    
                }
                
                
            }
        }
        
        return ans;
    }
};
