class Solution {
    public int maximumSwap(int num) {
        
        
        StringBuilder nums = new StringBuilder(Integer.toString(num));
        int n = nums.length();
        if (n == 1) {
            return num;
        }
        int maxDigit = nums.charAt(n-1) - '0';
        int minDigit = nums.charAt(n-2) - '0';
        int maxPos = n - 1;
        int minPos = n - 2;
        int maxNumber = num;
        for (int i = n - 2; i >= 0; i--) {
            int digitOne = (int) nums.charAt(i + 1) - '0';
            int digitTwo = (int) nums.charAt(i) - '0';
            if (maxDigit < digitOne) {
                    maxDigit = digitOne;
                    maxPos = i + 1;
            }

            if (minDigit >= digitTwo || digitTwo < maxDigit) {
                    minDigit = digitTwo;
                    minPos = i;
            }
            if (maxDigit > minDigit && maxPos > minPos) {
                char minCharNum = (char) ('0' + minDigit);
                char maxCharNum = (char) ('0' + maxDigit);
                char tempOne = nums.charAt(maxPos);
                char tempTwo = nums.charAt(minPos);
                nums.setCharAt(maxPos, minCharNum);
                nums.setCharAt(minPos, maxCharNum);
                maxNumber = Math.max(maxNumber, Integer.parseInt(nums.toString()));
                nums.setCharAt(maxPos, tempOne);
                nums.setCharAt(minPos, tempTwo);
            }
        }
        
        return maxNumber;
    }
}