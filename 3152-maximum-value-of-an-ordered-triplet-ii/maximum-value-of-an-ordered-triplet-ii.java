class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long answer = 0;
        long max = nums[0];
        long maxDiff = 0;
        for (int i = 1; i < n; i++) {
            answer = Math.max(answer, maxDiff * nums[i]);
            maxDiff = Math.max(maxDiff, max - nums[i]);
            max = Math.max(max, nums[i]);
        }

        return answer;
    }
}