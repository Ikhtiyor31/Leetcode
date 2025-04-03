class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long answer = 0;
        long max = nums[0];
        long min = nums[1];
        long maxDiff = max - min;
        for (int i = 2; i < n; i++) {
            answer = Math.max(answer, (maxDiff) * nums[i]);
            if (max < nums[i-1]) {
                max = nums[i-1];
                min = nums[i];
            } else {
                min = Math.min(min, nums[i]);
            }
            maxDiff = Math.max(maxDiff, max - min);
        }

        return answer;
    }
}