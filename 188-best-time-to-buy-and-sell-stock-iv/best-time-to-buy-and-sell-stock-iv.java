class Solution {
    int[][][] memo = new int[1001][101][2];
    public int dp(int[] prices, int k, int i, boolean isPurchased) {
        if (i >= prices.length || k == 0) {
            return 0;
        }
        if (memo[i][k][isPurchased ? 1 : 0] != -1) {
            return memo[i][k][isPurchased ? 1 : 0];
        }

        int profit = 0;
        if (!isPurchased) {
            int buy = dp(prices, k, i + 1, true) - prices[i];
            int skip = dp(prices, k, i + 1, false);
            profit = Math.max(buy, skip);
        } else {
            int sell = dp(prices, k - 1, i + 1, false) + prices[i];
            int skip = dp(prices, k, i + 1, true);
            profit = Math.max(sell, skip);
        }
        
        return memo[i][k][isPurchased? 1 : 0] = profit;
    }

    public int maxProfit(int k, int[] prices) {
        for (int i = 0; i < 101; i++) {
            for(int j = 0; j < 1001; j++) {
                Arrays.fill(memo[j][i], -1);
            }
        }
        //System.out.println(Arrays.deepToString(memo));
        return dp(prices, k, 0, false);
    }
}


