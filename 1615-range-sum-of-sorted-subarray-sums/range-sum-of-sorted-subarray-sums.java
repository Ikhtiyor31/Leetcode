class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        final int mod = (int)1e9 + 7;
        int newLength = n * (n + 1) / 2;
        int[] newArray = new int[newLength];
        int k = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++, k++) {
                sum += nums[j];
                newArray[k] = sum;
            }
        }
        
        Arrays.sort(newArray);
        int sum = 0;
        for (int i = left - 1; i < right; i++) {
            sum = (sum + newArray[i]) % mod;
        }
       
        return sum % mod;
    }
}