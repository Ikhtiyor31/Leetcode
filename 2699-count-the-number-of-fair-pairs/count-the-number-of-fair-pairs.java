class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        long answer = 0;
        while (i < j) {
            int target = nums[i] + nums[j];
            if (lower <= target && target <= upper) {
                // binary search 
                int l = i;
                int r = j;
                int min = 0;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (mid < j && nums[mid] + nums[j] <= upper) {
                        min = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                answer += (min - i) + 1;
                j--;
            } else if (lower > target) {
                i++;
            } else {
                j--;
            }
        }

        return answer;
    }
}

/*
nums = [0, 1, 4, 4, 5, 7]
lower = 3, upper = 6
pair(0, 5)
pair(1, 5)
pair(1, )
[1,2,5,7,9]



*/