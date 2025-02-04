class Solution {
    public boolean check(int[] nums) {
        
        int n = nums.length;
        if (n == 1) return true;
        for (int i = 1; i < n; i++) {
            if (nums[i-1] > nums[i]) {
                break;
            }
            if (n - 1 == i) return true;
        }
        int count = 0;
        if (nums[0] < nums[n-1]) return false;
        for (int i = 1; i < n; i++) {
            if (nums[i-1] > nums[i]) {
                count++;
            }
            if (count > 1) return false;
            
        }

        return true;
    }
}