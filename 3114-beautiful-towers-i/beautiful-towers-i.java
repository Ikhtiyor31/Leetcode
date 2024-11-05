class Solution {
    public long maximumSumOfHeights(int[] heights) {
        int n = heights.length;
        long max = 0;
        for (int i = 0; i < n; i++) {
            int l = i - 1;
            int r = i + 1;
            long sum = heights[i];
            long prev = heights[i];
            while (l >= 0) {
                if (heights[l] > prev) {
                    sum += prev;
                } else {
                    sum += heights[l];
                    prev = heights[l];
                }
                l--;
            }
            prev = heights[i];
            while (r < n) {
                if (heights[r] > prev) {
                    sum += prev;
                } else {
                    sum += heights[r];
                    prev = heights[r];
                }
                r++;
            }
            max = Math.max(max, sum);
        }

        return max;
    }
}