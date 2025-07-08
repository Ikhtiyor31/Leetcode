class Solution {
    int dp(int[][] events, int i, int prevEndingTime, int k, int[][] memo) {
        if (i >= events.length || k == 0) {
            return 0;
        }

        if (prevEndingTime >= events[i][0]) {
            return dp(events, i + 1, prevEndingTime, k, memo);
        }
        if (memo[k][i] != -1) {
            return memo[k][i];
        }

        int leave = dp(events, i + 1, prevEndingTime, k, memo);
        int take = events[i][2] + dp(events, i + 1, events[i][1], k - 1, memo);

        return memo[k][i] = Math.max(leave, take);
    }
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(event -> event[0]));
        int[][] memo = new int[k + 1][events.length];
        for (int[] row: memo) {
            Arrays.fill(row, -1);
        }
        return dp(events, 0, 0, k, memo);
    }
}