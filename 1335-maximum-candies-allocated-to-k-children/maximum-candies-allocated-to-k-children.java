class Solution {
    public int maximumCandies(int[] candies, long k) {
        // binary 
        int number = Arrays.stream(candies).max().getAsInt();
        int n = candies.length;
        int l = 1;
        int r = number;
        int maxCandy = 0;
        while (l <= r) {
            long count = 0;
            int pile = l + (r - l) / 2;
            for (int candy: candies) {
                count += (candy / pile);
            }

            if (count >= k) {
                maxCandy = Math.max(maxCandy, pile);
                l = pile + 1;
            } else {
                r = pile - 1;
            }
        }

        return maxCandy;
    }
}