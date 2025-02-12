class Solution {
    public int getDigtisSum(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit;
            num /= 10;
        }

        return sum;
    }
    public int maximumSum(int[] nums) {
        int[] digitMap = new int[82];
        int maximumSum = -1;
        for (int num: nums) {
            int digitsSum = getDigtisSum(num);
            if (digitMap[digitsSum] == 0) {
                digitMap[digitsSum] = num;
                continue;
            }

            maximumSum = Math.max(maximumSum,digitMap[digitsSum] + num);
            digitMap[digitsSum] = Math.max(digitMap[digitsSum], num);
        }

       
      
        return maximumSum;
    }
}
/*
72

9: [72, 36]
7: [43, 7]
4: [13]


*/