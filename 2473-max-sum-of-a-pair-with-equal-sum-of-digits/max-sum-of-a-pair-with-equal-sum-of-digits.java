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
        Map<Integer, Integer> freqMap = new HashMap<>();
        int maximumSum = -1;
        for (int num: nums) {
            int digitsSum = getDigtisSum(num);
            if (!freqMap.containsKey(digitsSum)) {
                freqMap.put(digitsSum, num);
                continue;
            }

            maximumSum = Math.max(maximumSum, freqMap.get(digitsSum) + num);
            freqMap.put(digitsSum, Math.max(freqMap.get(digitsSum), num));
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