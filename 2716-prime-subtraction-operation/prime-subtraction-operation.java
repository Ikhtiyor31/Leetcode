class Solution {
    private int findMaxPrimeLessThan(int current, int next) {
        // Iterate from current - 1 down to 2 to find the largest prime
        for (int i = 1; i < current; i++) {
            if (isPrime(i) && current - i < next) {
                return current - i;
            }
        }
        return -1;
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
            int result = findMaxPrimeLessThan(nums[i], nums[i+1]);
            if (result == -1) {
                return false;
            }
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