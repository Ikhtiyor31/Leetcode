class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] prefixXOR = new int[n];
        
        prefixXOR[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixXOR[i] = prefixXOR[i-1] ^ nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = (prefixXOR[n-i-1] ^ ((1 << maximumBit) - 1));
        }


        return nums;
        
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