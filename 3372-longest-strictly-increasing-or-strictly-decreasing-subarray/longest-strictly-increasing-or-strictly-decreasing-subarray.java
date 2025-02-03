class Solution {
    public int longestMonotonicSubarray(int[] nums) {

        int currentLength = 1;
        int longestLength = 1;
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            if (nums[i - 1] >= nums[i]) {
                currentLength = 0;
            }
            longestLength = Math.max(longestLength, ++currentLength);
        }

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i + 1] >= nums[i]) {
                currentLength = 0;
            } 
            longestLength = Math.max(longestLength, ++currentLength);
        }

        return longestLength;
    }
}