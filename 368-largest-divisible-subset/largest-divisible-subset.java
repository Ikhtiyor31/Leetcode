class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
              
            }
            max = Math.max(max, dp[i]);
        }

        List<Integer> answer = new ArrayList<>();
        int prev  = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (max == dp[i] && (prev == -1 || prev % nums[i] == 0)) {
                prev = nums[i];
                answer.add(nums[i]);
                max -= 1;
            }
        }

        return answer;
    }
}