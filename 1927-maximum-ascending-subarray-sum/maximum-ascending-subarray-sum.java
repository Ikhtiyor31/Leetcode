class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int maxAscendingSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i-1] >= nums[i]) {
                currentSum = 0;
            }
            currentSum += nums[i];
            maxAscendingSum = Math.max(maxAscendingSum, currentSum);
        }

        return maxAscendingSum;
    }
}