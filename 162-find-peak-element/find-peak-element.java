class Solution {
    public int findPeakElement(int[] nums) {
        
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[m + 1]) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }
}