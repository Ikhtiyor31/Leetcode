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
        int n = nums.length;
        return findSubsetSum(nums, 0, 0);
    }
}