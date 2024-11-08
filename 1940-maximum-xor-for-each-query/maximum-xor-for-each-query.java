class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int result = nums[0];
        for (int i = 1; i < n; i++) {
            result ^= nums[i];
        }
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = result ^ ((1 << maximumBit) - 1);
            result ^= nums[n-i-1];
        }

        return ret;
        
    }
}

/*
'0010'
'0011'
'0100'
'0111'
'0101'
'1010'
*/