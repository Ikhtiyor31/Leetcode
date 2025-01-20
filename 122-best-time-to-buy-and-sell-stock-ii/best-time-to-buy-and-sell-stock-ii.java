class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int price: prices) {
            if (price > minPrice) {
                maxProfit += price - minPrice;
            }
            minPrice = price;
        }

        return maxProfit;
    }
}

/*
7, 1, 5, 3, 6, 4
1 5, 3 6


1,2,3,4,5
1 - 2, 3 4
*/