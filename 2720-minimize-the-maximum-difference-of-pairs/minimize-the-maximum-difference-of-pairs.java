class Solution {
    public int minimizeMax(int[] nums, int p) {
         Arrays.sort(nums); // Sorting helps in minimizing the difference for pairs
        int left = 0;
        int right = nums[nums.length - 1] - nums[0]; // Max possible difference
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (canFormPairs(nums, p, mid)) {
                right = mid; 
            } else {
                left = mid + 1; 
            }
        }
        
        return left;
    }

     private boolean canFormPairs(int[] nums, int p, int maxDiff) {
        int pairs = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] <= maxDiff) {
                pairs++;
                i++; // Skip next as it's already paired
            }
            if (pairs >= p) return true;
        }
        return pairs >= p;
    }
}