class Solution {
    public int longestMonotonicSubarray(int[] nums) {

        int len1 = 1;
        int longestLength = 1;
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i]) {
                len1++;
            } else {
                longestLength = Math.max(longestLength, len1);
                len1 = 1;
            }
            longestLength = Math.max(longestLength, len1);
        }

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i + 1] < nums[i]) {
                len1++;
            } else {
                longestLength = Math.max(longestLength, len1);
                len1 = 1;
            }
            longestLength = Math.max(longestLength, len1);
        }

        return longestLength;
    }
}