class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0;
        int h = nums[n - 1] - nums[0];
        while (l < h) {
            int mid = l + (h - l) / 2;
            int j = 1, count = 0;
            for (int i = 0; i < n; i++) {
                while(j < n && nums[j] - nums[i] <= mid)j++;
                count += j - i - 1;
            }

            if (count < k) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }

        return l;
    }
}

// [1,6,1]
// 1, 6
// 1, 1
// 6, 1