 //https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3483
class Solution {

public:
    
    int removeCoveredIntervals(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end(), [&](const auto &it1, const auto &it2) {
            if(it1[0] == it2[0])
                return false;
            return it1[0]  < it2[0];
        });
        int n = intervals.size();
        int c = 0;
        
        //for(vector<int> p : intervals)
          //   cout << p[0] << " and " << p[1] <<"\n";
        for(int i = 1; i < n; i++) {
           // cout << intervals[i-1][0] << " and " << intervals[i-1][1] << "\n";
            if(intervals[i-1][0] <= intervals[i][0] && intervals[i-1][1] >= intervals[i][1]) {
                swap(intervals[i-1], intervals[i]);
                c++;
            } else if(intervals[i-1][0] >= intervals[i][0] && intervals[i-1][1] <= intervals[i][1]) {
                c++;
            }
        }
        
        
        return n-c;
    }
};
