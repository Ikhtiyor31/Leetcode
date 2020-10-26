class Solution {
public:
    vector<bool> checkArithmeticSubarrays(vector<int>& nums, vector<int>& l, vector<int>& r) {
        int n = nums.size();
        int m = l.size();
        vector<bool> ret;
        int j = 0;
        while(j < m) {
              multiset<int> ans;
             
             for(int i = l[j]; i <= r[j]; i++) {
                 
                 ans.insert(nums[i]);
             }
            
            int it = *ans.begin();
            ans.erase(ans.begin());
            set<int> tmp;
            for(int x : ans) {
                tmp.insert(abs(it-x));
                it = x;
            }
            
            if(tmp.size()==1) {
                ret.push_back(true);
            } else {
                ret.push_back(false);
            }
            j++;
        }
        return ret;
    }
};
