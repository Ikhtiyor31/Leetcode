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
        /*memo = new int[101];
        Arrays.fill(memo, -1);
        return Math.max(rob(nums, 0), rob(nums, 1)); */
      
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[101];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }
}