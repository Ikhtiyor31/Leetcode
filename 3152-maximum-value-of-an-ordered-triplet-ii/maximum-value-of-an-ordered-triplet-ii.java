class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long answer = 0;
        int maxDiff = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            long result = (long)maxDiff * nums[i];
            answer = Math.max(answer, result);
            maxDiff = Math.max(maxDiff, max - nums[i]);
            max = Math.max(max, nums[i]);
        }

        return answer;
    }
}