class Solution {
    int[][] memo = new int[201][20001];
    public boolean findHalfSum(int[] nums, int i, int target) {
        if (i >= nums.length) {
            return false;
        }
        if (target < 0) {
            return false;
        }
        if (target == 0) {
            return true;
        }

        if (memo[i][target] != -1) {
            return memo[i][target] == 1;
        }
        for (int j = i; j < nums.length; j++) {
            boolean result = findHalfSum(nums, j + 1, target - nums[j]);
            memo[i][target] = result ? 1 : 0;
            if (result == true) {
                return true;
            }
        }
        memo[i][target] = 0;
        return  false;
    }
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        for (int i = 0; i < 200; i++) {
            Arrays.fill(memo[i], -1);
        }
        boolean isHalfExist = findHalfSum(nums, 0, sum / 2);

        return isHalfExist;
    }
}