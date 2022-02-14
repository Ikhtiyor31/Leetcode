class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        if(intervals.empty())
            return {{}};
        int n = intervals.size();
        sort(intervals.begin(), intervals.end(), [&] (const auto &x, const auto &y) {
            return x < y;
        });
        vector<vector<int>> ret;
        int start = intervals[0][0];
        int end = intervals[0][1];
        ret.push_back(vector<int>{start, end});
        for(int i = 1; i < n; i++) {
            if (end >= intervals[i][0]) {
                if (end < intervals[i][1]) {
                    ret.back().pop_back();
                    ret.back().push_back(intervals[i][1]);
                    end = intervals[i][1];
                }
            } else {
                start = intervals[i][0];
                end = intervals[i][1];
                ret.push_back(vector<int> {start, end});
            }
        }
        return ret;
    }
};
