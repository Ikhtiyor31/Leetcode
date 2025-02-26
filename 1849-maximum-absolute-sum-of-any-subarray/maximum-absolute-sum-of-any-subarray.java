class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int absMaxSum = nums[0];
        int maxSum = nums[0];
        int currSum = 0;
        int absCurrSum = 0;
        for (int num: nums) {
            currSum = Math.max(0, Math.max(num, currSum + num));
            absCurrSum = Math.min(num, absCurrSum + num);
            maxSum = Math.max(Math.abs(absCurrSum), Math.max(currSum, maxSum));
        }

        return maxSum;
    }
}