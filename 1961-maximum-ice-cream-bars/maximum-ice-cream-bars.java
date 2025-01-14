class Solution {
    public int maxIceCream(int[] costs, int coins) {
        
        int max = Arrays.stream(costs).max().getAsInt();
        int[] bucket = new int[max + 1];
        int n = costs.length;
        for (int cost: costs) {
            bucket[cost]++;
        }

        int ans = 0;

        for (int i = 1; i < bucket.length; i++) {
            if (coins < i) break;
                
            if (bucket[i] * i <= coins) {
                ans += bucket[i];
                coins -= (bucket[i] * i);
            } else {
                ans += (coins / i);
                coins -= coins;
            }
        }


        return ans;
    }
}