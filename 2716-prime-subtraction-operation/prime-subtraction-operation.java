class Solution {
    private boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i  == 0)
                return false;
        }

        return true;
    }
    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        int maxElement = Arrays.stream(nums).max().getAsInt();
        int[] previousPrimes = new int[maxElement + 1];
        for (int i = 2; i <= maxElement; i++) {
            if (isPrime(i)) {
                previousPrimes[i] = i;
            } else {
                previousPrimes[i] = previousPrimes[i-1];
            }
        }

        for (int i = 0; i < n; i++) {
            int bound = 0;
            if (i == 0) {
                bound = nums[i];
            } else {
                bound = nums[i] - nums[i-1];
            }

            if (bound <= 0) {
                return false;
            }

            nums[i] -= previousPrimes[bound - 1];

        }

        return true;
    }
}