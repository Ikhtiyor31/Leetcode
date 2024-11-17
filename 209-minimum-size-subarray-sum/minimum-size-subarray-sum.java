class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;

        int l = 0;
        int sum = 0;
        int minSize = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (target <= sum) {
                minSize = Math.min(minSize, i - l + 1);
                sum -= nums[l++];
            }

            
        }

        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}