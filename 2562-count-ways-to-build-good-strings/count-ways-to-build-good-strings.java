class Solution {
    int mod = 1_000_000_007;
    public int pleaseTry(int low, int high, String zero, String one, int form, Map<Integer, Integer> memo) {
        if (form > high) {
            return 0;
        }
        if (memo.containsKey(form)) {
            return memo.get(form);
        }
        int count = form  >= low ? 1 : 0;
        count += pleaseTry(low, high, zero, one, form + zero.length(), memo);
        count %= mod;
        count += pleaseTry(low, high, zero, one, form + one.length(), memo);
        count %= mod;

        memo.put(form, count);
        return count;
        
    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        
        String zeros = "";
        String ones = "";
        for (int i = 1; i <= zero; i++) {
            zeros += "0";
        }

        for (int i = 1; i <= one; i++) {
            ones += "1";
        }

        Map<Integer, Integer> memo = new HashMap<>();
        return pleaseTry(low, high, zeros, ones, 0, memo);
     
    }
}
/*
 low = 2, high = 3, zero = 1, one = 2 // "0" "11"

        


*/