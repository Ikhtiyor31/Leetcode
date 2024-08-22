class Solution {
    public int findComplement(int num) {
        int n = 0;
        while (n < num) {
            n = (n << 1) | 1;
            System.out.println(n);
        }

        return n-num;
    }
} // 101 
  // 101