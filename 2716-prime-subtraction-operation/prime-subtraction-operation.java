class Solution {
    private int findMaxPrimeLessThanN(int n, int next) {
        int maxPrime = -1; 
        for (int i = n - 1; i > 1; i--) {
            if (isPrime(i)) {
                if (n - i > maxPrime && next > n - i) {
                    maxPrime = n - i;
                }
            }
        }
        return maxPrime;
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i-1] >= nums[i]) {
                break;
            }
            if (i == n - 1) return true;
        }
       
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                continue;
            }
            int result = findMaxPrimeLessThanN(nums[i], nums[i+1]);
            nums[i] = result != -1 ? result : nums[i];
            //System.out.println(nums[i]);
        }

        for (int i = 1; i < n; i++) {
           
            if (nums[i-1] >= nums[i]) {
                return false;
            }
        }
       

        return true;
    }
}

/*

[4, 9, 6, 10]

 0  1  2   3
           

*/