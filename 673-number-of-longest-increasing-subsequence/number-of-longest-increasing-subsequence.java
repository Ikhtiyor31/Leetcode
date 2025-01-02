class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];

        int max = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i][0] < dp[j][0] + 1) {
                        dp[i][0] = dp[j][0] + 1;
                        dp[i][1] = 0;
                    }
                    if (dp[i][0] == dp[j][0] + 1) {
                        dp[i][1] += dp[j][1];
                    } 
                }   
            }
        }

        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i][0]);
        }

        for (int i = 0; i < n; i++) {
            if (dp[i][0] == max) {
                count += dp[i][1];
            }
        }

       return count;
    }
}

/*
[1, 3, 5, 4, 7]
     

*/