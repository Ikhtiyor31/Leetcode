class Solution {

    private Map<String, Long> memo = new HashMap<>();

    public long dfs(List<Integer> robot, int[][] factory, int i, int j, int cnt) {
        // Base case
        if (i >= robot.size()) {
            return 0; // All robots are repaired
        }
        if (j >= factory.length) {
            return (long) 1e12; // No valid path
        }

        // Check memoization
        String key = i + "," + j + "," + cnt;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        long repair = Long.MAX_VALUE;

        // Check if the current factory can repair more robots
        if (factory[j][1] > cnt) {
            repair = Math.abs(factory[j][0] - robot.get(i)) + dfs(robot, factory, i + 1, j, cnt + 1);
        }

        // Skip to the next factory and reset count
        long skip = dfs(robot, factory, i, j + 1, 0);

        // Store the result in memo and return the minimum of repair or skip
        long result = Math.min(repair, skip);
        memo.put(key, result);

        return result;
    }

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));
       
        return dfs(robot, factory, 0, 0, 0);

    }
}