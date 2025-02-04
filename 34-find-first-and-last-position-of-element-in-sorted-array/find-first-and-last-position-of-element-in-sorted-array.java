class Solution {
    public int binarySearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] >= target) {
                r = m - 1;
            } else {
                l = m  + 1;
            }
        }

        return l;
    }
    public int[] searchRange(int[] nums, int target) {
        int first = binarySearch(nums, target);
        int second = binarySearch(nums, target + 1);
        if (first <= second - 1) {
            return new int[]{first, second - 1};
        }

        return new int[]{-1, -1};

    }
}