class Solution {
    public int arraySign(int[] nums) {
        int sign = 1;
        for (int x: nums) {
            if (x == 0) {
                return 0;
            }
            sign *= x > 0 ? 1: -1;
        }

        return sign >= 0 ? 1 : -1;
    }
}