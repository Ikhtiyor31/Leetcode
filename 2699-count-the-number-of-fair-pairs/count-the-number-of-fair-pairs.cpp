class Solution {
public:
    long long countFairPairs(vector<int>& nums, int lower, int upper) {
        sort(nums.begin(), nums.end());
        int n = nums.size();
        long long count = 0;
        for (int i = 0; i < n; i++) {
            auto s = lower_bound(nums.begin() + i + 1, nums.end(), lower - nums[i]) - nums.begin();
            auto e = upper_bound(nums.begin() + i + 1, nums.end(), upper - nums[i]) - nums.begin() - 1;

            if (s <= e) {
                count += (e - s + 1);
            }
        }

        return count;
    }
};

/*
[0,1,4,4,5,7] 

[1,2,5,7,9]

*/