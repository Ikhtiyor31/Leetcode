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
        Map<Integer, List<Integer>> freqList = new HashMap<>();
        for (int num: nums) {
            int digitsSum = getDigtisSum(num);
            if (!freqList.containsKey(digitsSum)) {
                freqList.put(digitsSum, new ArrayList<>());
            }
           
            freqList.get(digitsSum).add(num);
            if (freqList.get(digitsSum).size() > 2) {
                List<Integer> list = freqList.get(digitsSum);
                Collections.sort(list, Comparator.reverseOrder());
                freqList.get(digitsSum).remove(list.size()-1);
                freqList.get(digitsSum).set(0, list.get(0));
                freqList.get(digitsSum).set(1, list.get(1));
            }
        }

        int maximumSum = -1;
        for (List<Integer> list: freqList.values()) {
            if (list.size() > 1) {
                maximumSum = Math.max(maximumSum, list.get(0) + list.get(1));
            }
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