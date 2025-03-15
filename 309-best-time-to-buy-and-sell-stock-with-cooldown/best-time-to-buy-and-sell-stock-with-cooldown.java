class Solution {
    int[] memo;
    public int dp(int[] prices, int i, boolean isPurchased, HashMap<String, Integer> memo) {
        if (i >= prices.length) {
            return 0;
        }
        String key = i + "," + isPurchased;
        if (memo.containsKey(key)) return memo.get(key);
        int profit = 0, coolDown = 0;
        if (!isPurchased) {
            profit = dp(prices, i + 1, !isPurchased, memo) - prices[i];
            coolDown = dp(prices, i + 1, isPurchased, memo);
        } else {
            profit = dp(prices, i + 2, !isPurchased, memo)  + prices[i];
            coolDown = dp(prices, i + 1, isPurchased, memo);
        }
        memo.put(key, Math.max(profit, coolDown));
        return Math.max(profit, coolDown);
    }
    public int maxProfit(int[] prices) {
        return dp(prices, 0, false, new HashMap<>());
    }
}