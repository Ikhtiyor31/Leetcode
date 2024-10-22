class Solution {
    public int smallestRepunitDivByK(int k) {
        long n = 0;
      
        int i = 1;
        while (i <= k) {
            n = (n * 10 + 1) % k;
            System.out.println(n);
            if (n == 0) {
                return i;
            }
            i++;
        }

        return -1;
    }
}