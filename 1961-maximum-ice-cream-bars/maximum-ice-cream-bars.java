class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        for (int i = 0; i < costs.length; i++) {
            if (coins - costs[i] >= 0) {
                count = i + 1;
                coins -= costs[i];
            }
        }

        return count;
    }
}