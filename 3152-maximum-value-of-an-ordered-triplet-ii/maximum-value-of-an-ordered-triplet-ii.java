class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long answer = 0;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        int[] suffix = new int[n];
        suffix[n-1] = nums[n-1];
        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], nums[i]);
            suffix[n-i-1] = Math.max(suffix[n-i], nums[n-i-1]);
        }
        for (int j = 1; j < n - 1; j++) {
            answer = Math.max(answer, (long)(prefix[j-1] - nums[j]) * suffix[j+1]);
        }
        return answer;
    }
}