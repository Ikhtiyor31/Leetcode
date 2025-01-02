class Solution {
    int[] memo;
    public int rob(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        return memo[i] = Math.max(rob(nums, i + 1), rob(nums, i + 2) + nums[i]);
    }
    public int rob(int[] nums) {
        memo = new int[101];
        Arrays.fill(memo, -1);
        return Math.max(rob(nums, 0), rob(nums, 1));
    }
}