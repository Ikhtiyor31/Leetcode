class Solution {
    public int maximumDifference(int[] nums) {
        
        int n = nums.length;
        int maxAnswer = -1;
      
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i])
                    maxAnswer = Math.max(maxAnswer, nums[j] - nums[i]);
            }
        }

        return maxAnswer;
    }
}