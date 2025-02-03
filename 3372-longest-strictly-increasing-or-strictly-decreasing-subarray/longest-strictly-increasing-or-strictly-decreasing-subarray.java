class Solution {
    public int longestMonotonicSubarray(int[] nums) {

        int currentLength1 = 1;
        int currentLength2 = 1;
        int longestLength = 1;
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            if (nums[i - 1] >= nums[i]) {
                currentLength1 = 0;
            }
            if (nums[n-i] >= nums[n-i-1]) {
                currentLength2 = 0;
            }

            longestLength = Math.max(longestLength, Math.max(++currentLength1, ++currentLength2));
        }

        return longestLength;
    }
}