class Solution {
    public int backtrack(int[] nums, int target, int current, int index) {
         
        if (index >= nums.length) {
            if (current == target) {
                return 1;
            }
            return 0;
        }
       
        int count = 0;

        count += backtrack(nums, target, nums[index] + current, index + 1);
        count += backtrack(nums, target, (nums[index] * -1) + current, index + 1);
        

        return count;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return backtrack(nums, target, 0, 0);
    }
}