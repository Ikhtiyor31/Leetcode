class Solution {
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        for (int i = 2; i < n; i++) {
            primes[i] = true;
        }

        for (int i = 0; i *i< n; i++) {
            if (!primes[i])
                continue;
            for (int j = i * i; j < n; j += i) {
                primes[j] = false;
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (primes[i])
                count++;
        }

        return count;
    }
}