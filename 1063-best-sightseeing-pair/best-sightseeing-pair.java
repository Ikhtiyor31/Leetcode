class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int maxScore = 0;
        int l = 0;
        int r = 1;
        while (r < n) {
            maxScore = Math.max(maxScore, values[l] + values[r] + (l - r));
            if (values[l] < values[r] + (r - l)) {
                l = r;
            }
            r += 1;
        }

        return maxScore;
    }
}