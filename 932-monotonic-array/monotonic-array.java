class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        if (n == 1) return true;
        // increasing 
        for (int i = 1; i < n; i++) {
            if (nums[i-1] > nums[i]) {
                break;
            }
            if (i == n - 1) return true;
        }
       
        for (int i = 1; i < n; i++) {
            if (nums[i-1] < nums[i]) {
                break;
            }
            if (i == n - 1) return true;
        }
        
        return false;
    }
}