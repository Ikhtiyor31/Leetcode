class Solution {
    public int mySqrt(int x) {
        if (x <= 1) return x;

        int r = x / 2;
        int l = 1;
        while (l < r) {
            int m = (l + (r - l) / 2) + 1;
            if (m == x / m) {
                return m;
            } else if (m < x / m) {
                l = m;
            } else {
                r = m - 1;
            }
        }


        return l;
    }
}