class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        if (k == 1) {
            return nums;
        }
        
        int[] ans = new int[n - k + 1];
        int consecutiveCount = 1;
        
        for (int i = 1; i < n; i++) {
            if (nums[i-1] + 1 == nums[i]) {
                consecutiveCount++;
            } else {
                consecutiveCount = 1;
            }
            
            if (consecutiveCount >= k || k == 1) {
                
                ans[i - k + 1] = nums[i];
            } else if (i + 1 >= k) {
                ans[i - k + 1] = -1;
            }
        }

        return ans;
    }
}