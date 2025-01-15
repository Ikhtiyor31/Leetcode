class Solution {
    public int minimizeXor(int num1, int num2) {
        int countNum2 = Integer.bitCount(num2);
        int countX = Integer.bitCount(num1);
        int i = 0;
        while (countNum2 < countX) {
            if ((num1 & (1 << i)) != 0) {
                num1 &= ~(1 << i);
                countX--;
            }
            i++;
        }

        while (countNum2 > countX) {
            if ((num1 & (1 << i)) == 0) {
                num1 |= (1 << i);
                countX++;
            }
            i++;
        }

        return num1;
    }
}