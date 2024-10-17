class Solution {
    public int maximumSwap(int num) {
        
        String numStr = Integer.toString(num);
        char[] digits = numStr.toCharArray();
        int n = digits.length;
        int[] last = new int[10];
        for (int i = 0; i < n; i++) {
            last[digits[i] - '0'] = i;
        }
        
        for (int i = 0; i < n; i++) {
            for (int d = 9; d > digits[i] - '0'; d--) {
                if (last[d] > i) {
                    char c = digits[i];
                    digits[i] = (char)('0' + d);
                    digits[last[d]] = c;
                    System.out.println(digits);
                    return Integer.parseInt(new String(digits));
                }
            }
        }


        return num;
    }
}

// 3366