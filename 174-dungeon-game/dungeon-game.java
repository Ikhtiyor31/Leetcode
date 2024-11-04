class Solution {
     private Map<String, Integer> memo = new HashMap<>();
    public int dfs(int[][] dungeon, int i, int j) {
        
        if (i == dungeon.length - 1 && dungeon[i].length - 1 == j) {
            return Math.max(1, 1 - dungeon[i][j]);
        }

        if (i >= dungeon.length || j >= dungeon[i].length) {
            return Integer.MAX_VALUE;
        }

        String key = i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int rightward = dfs(dungeon, i + 1, j);
        int downward = dfs(dungeon, i, j + 1);

        int requiredHealth = Math.min(rightward, downward) - dungeon[i][j];
        memo.put(key, Math.max(requiredHealth, 1));
        return Math.max(requiredHealth, 1);
    } 
    public int calculateMinimumHP(int[][] dungeon) {
        
        return dfs(dungeon, 0, 0);
    }
}