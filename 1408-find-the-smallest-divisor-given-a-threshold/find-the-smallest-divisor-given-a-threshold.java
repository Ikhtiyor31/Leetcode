class Solution {
    public boolean isSmallestDivisor(int divisor, int[] nums, int threshold) {
        int sum = 0;
        for (int num: nums) {
            sum += Math.ceil((double) num / divisor);
        }
       
        return sum <= threshold;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 0;
        int r = 1000000000;
        int ans = 0;
        while (l <= r) {
            int m = l + (r - l) / 2;
            
            if (isSmallestDivisor(m, nums, threshold)) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return ans;
    }
}