class Solution {
    int[] memo;
    public int minCostClimbingStairs(int[] cost, int i) {
        if (i >= cost.length) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        int oneStep = minCostClimbingStairs(cost, i + 1) + cost[i];
        int twoStep = minCostClimbingStairs(cost, i + 2) + cost[i];

        return memo[i] = Math.min(oneStep, twoStep);
    }
    public int minCostClimbingStairs(int[] cost) {
        memo = new int[1000];
        Arrays.fill(memo, -1);
        return Math.min(minCostClimbingStairs(cost, 0), minCostClimbingStairs(cost, 1));
    }
}