class Solution {
    public int concatenatedBinary(int n) {
        final int modulo = 1000000007;
        long result = 0;
        for (int i = 1; i <= n; i++) {
            result = (((result<<(1+(int)(Math.log(i) / Math.log(2))))%modulo)+i)%modulo;        
        }
        return (int) result;
    }
}