class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long suffixSum = 0;
        for (int i = n - 1; i > 0; i--) {
            suffixSum += nums[i];
        }

        int ways = 0;
        long prefixSum = 0;
        for (int i = 0; i < n - 1; i++) {
            prefixSum += nums[i];
            if (prefixSum >= suffixSum) {
                ways++;
            }
            suffixSum -= nums[i+1];
        }

        return ways;
    }
}