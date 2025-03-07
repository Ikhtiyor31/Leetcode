class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] memo = new int[prices.length][3];
        for (int i = 0; i < prices.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return maxProfit(prices, fee, 0, 1, memo);
    }

    public int maxProfit(int[] prices, int fee, int i, int status, int[][] memo) {
        if (i >= prices.length) {
            return 0;
        }

        if (memo[i][status] != -1) {
            return memo[i][status];
        }
        int result = 0;
        if (status == 1) {
            int buy = maxProfit(prices, fee, i + 1, 2, memo) + (-prices[i]);
            int skip = maxProfit(prices, fee, i + 1, 1, memo);
            result = Math.max(buy, skip);
        } else {
           int buy = maxProfit(prices, fee, i + 1, 1, memo) + (prices[i] - result - fee);
           int skip = maxProfit(prices, fee, i + 1, 2, memo);
           result = Math.max(buy, skip);
        }

        return memo[i][status] = result;
        
    }
}