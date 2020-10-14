//https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3482/
class Solution {
public:
    int findPairs(vector<int>& nums, int k) {
      int n = nums.size();
            int count =0;
            set<pair<int,int>> stp;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                
                if(k == abs(nums[i]-nums[j]) && stp.find({nums[i], nums[j]}) == stp.end() && stp.find({nums[j], nums[i]}) == stp.end()) {
                    count++;
                    stp.insert({nums[i], nums[j]});
                }
            }
        }
            return count;
    }
};
