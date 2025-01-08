class Solution {

    public int findMinFibonacciNumbers(int k) {
        
        if (k == 3 || k == 2 || k == 1) {
            return 1;
        }
        List<Integer> fib = new ArrayList<>();
        fib.add(1);
        fib.add(1);

        for (int i = 2; i < k; i++) {
            int sum = fib.get(i-1) + fib.get(i-2);
            if (sum > k) break;
            fib.add(sum);
        }
        int j = fib.size() - 1;
        int count = 0;
        while (k != 0) {
            if (k >= fib.get(j)) {
                k -= fib.get(j);
                count++;
            }
            j--;
        }
        

        return count;

    }
}