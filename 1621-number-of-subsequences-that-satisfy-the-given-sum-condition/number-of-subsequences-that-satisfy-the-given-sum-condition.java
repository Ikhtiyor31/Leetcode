class Solution {
    int mod = 1_000_000_00_7;
    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 2) % mod;
        }
        
        int l = 0;
        int r = n - 1;
        int count = 0;
        while (l <= r) {
            if (nums[l] + nums[r] > target) {
                r -= 1;
            } else {
                count = (int) (count + power[r - l]) % mod;
                l++;
            }
        }

        return count;
    }
}