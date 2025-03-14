class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int l = 0;
        int r = 0;
        int sum = 1;
        while (r < n) {
            sum *= nums[r];
            while (l <= r && sum >= k) {
                sum /= nums[l];
                l++;
            }
            count += (r - l + 1);
            r++;
        }

        return count < 0 ? 0 : count;
    }
}