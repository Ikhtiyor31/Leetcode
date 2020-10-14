//https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3481/
class Solution {
public:
    
    void dfs(int j, int sum, vector<int> & take, vector<vector<int>> & ans, int target, vector<int> candidates) {
        if(sum-target== 0){
            ans.push_back(take);
            take.pop_back();
            return;
        }
        if(sum-target > 0) {
           take.pop_bac
               k();
            return;
        }
        for(int i = j; i < candidates.size(); i++) {
            take.push_back(candidates[i]);
            dfs(i, sum+candidates[i], take, ans, target, candidates);
            
        }
        take.pop_back();
    }
     vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<int> take;
        vector<vector<int>> ans;
        int sum =0;
        dfs(0, sum, take, ans, target, candidates);
        return ans;
    }
};
