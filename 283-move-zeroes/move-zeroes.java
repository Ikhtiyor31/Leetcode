class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int zeros = 0;
        for (int num: nums) if (num == 0) zeros++;
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }
        }

        for (; i < n; i++) nums[i] = 0;
    }
}