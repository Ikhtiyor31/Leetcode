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
                //System.out.println(coins + " " + i); // 3 : 7
                while (bucket[i] != 0 && coins >= i) {
                    coins -= i;
                    bucket[i]--;
                    ans++;
                }
                coins = 0;
            }
        }


        return ans;
    }
}