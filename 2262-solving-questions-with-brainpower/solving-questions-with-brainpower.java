class Solution {

    public long dp(int[][] questions, int i, Map<Integer, Long> memo) {
        
        if (i >= questions.length) {
            return 0;
        }

        if (memo.containsKey(i)) {
            return memo.get(i);
        }

        int point = questions[i][0];
        int brainPower = questions[i][1];
        long solve = point + dp(questions, i + brainPower  + 1, memo);
        long skip = dp(questions, i + 1, memo);
        memo.put(i, Math.max(solve, skip));
        return Math.max(solve, skip);
    }
    public long mostPoints(int[][] questions) {
        return dp(questions, 0, new HashMap<>());
    }
}