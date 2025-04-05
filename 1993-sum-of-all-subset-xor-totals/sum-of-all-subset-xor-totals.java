class Solution {
    public int findSubsetSum(int[] nums, int i, int currentXOR) {
        if (i == nums.length) {
            return currentXOR;
        }
        int withElement = findSubsetSum(nums, i + 1, currentXOR ^ nums[i]);
        int withoutElement = findSubsetSum(nums, i + 1, currentXOR);
        return withElement + withoutElement;
    }
    public int subsetXORSum(int[] nums) {
        int result = 0;
        for (int num: nums) {
            result |= num;
        }
        return result << (nums.length - 1);
    }
}