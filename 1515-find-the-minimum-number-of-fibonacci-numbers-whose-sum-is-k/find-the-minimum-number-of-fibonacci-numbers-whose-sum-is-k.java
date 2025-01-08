class Solution {

    public int findMinFibonacciNumbers(int k) {

        if (k == 3 || k == 2 || k == 1) {
            return 1;
        }

        int a = 1;
        int b = 1;
        int c = 0;
        int i = 2;
        for (; i <= k; i++) {
            c = a;
            a = b;
            b = c + b;
            if (b > k) {
                break;
            }
        }

        int count = 0;
        while (k != 0) {
            if (k >= b) {
                k -= b;
                count++;
            }
            c = a;
            a = b - a;
            b = c;
        }

        return count;

    }
}