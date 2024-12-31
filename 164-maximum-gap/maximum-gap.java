class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        if (n == 1) {
            return 0;
        }
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i])
                max = Math.max(max, nums[i] - nums[i-1]);
        }

        return max;
    }
}