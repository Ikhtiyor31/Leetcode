class Solution {
    public int numOfSubarrays(int[] arr) {
        
        int mod = 1000000007;
        int oddCount = 0;
        int evenCount = 1;
        int n = arr.length;
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum % 2 == 1) {
                count += evenCount;
                oddCount++;
            } else {
                count += oddCount;
                evenCount++;
            }   
            count %= mod;
        }

        return count;
    }
}

/*



*/