class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return l;
    }
}