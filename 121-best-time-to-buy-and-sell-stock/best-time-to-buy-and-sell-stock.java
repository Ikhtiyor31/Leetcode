class Solution {
    public int maxProfit(int[] prices) {
        
        int maxProfit = 0;
        int currentMin = prices[0];
        for (int price: prices) {
            currentMin = Math.min(price, currentMin);
            maxProfit = Math.max(maxProfit, price - currentMin);
        }

        return maxProfit;
    }
}