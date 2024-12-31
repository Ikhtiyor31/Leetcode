class Solution {
    int mod = 1_000_000_007;
    public int dfs(int i, int zero, int one, int low, int high, Map<Integer, Integer> memo) {
        if (i > high) {
            return 0;
        } 
        if (memo.containsKey(i)) {
            return memo.get(i);
        }   

        int count = i >= low ? 1 : 0;
        count += dfs(i + zero, zero, one, low, high, memo);
        count %= mod;
        count += dfs(i + one, zero, one, low, high, memo);
        count %= mod;
        memo.put(i, count);
        return count;
    }

    public int countGoodStrings(int low, int high, int zero, int one) {
        

        int answer = 0;
        Map<Integer, Integer> memo = new HashMap<>();
        answer += dfs(0, zero, one, low, high, memo);
        answer %= mod;
        
        return answer;
    }
}