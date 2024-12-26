class Solution {
    public int backtrack(int[] nums, int target, int current, int index) {
        
        if (index == nums.length) {
            if (current == target) {
                return 1;
            }
            return 0;
        }
       
        return backtrack(nums, target, +nums[index] + current, index + 1) +  backtrack(nums, target, (-nums[index]) + current, index + 1);
        
    }
    public int findTargetSumWays(int[] nums, int target) {
        return backtrack(nums, target, 0, 0);
    }
}