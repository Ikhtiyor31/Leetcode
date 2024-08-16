class Solution {
    public void backtrack(List<List<Integer>> answer, List<Integer> temp, int[] candidates, int target, int idx) {
        
        if (target == 0) {
            answer.add(new ArrayList<>(temp));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1])
            continue;
            temp.add(candidates[i]);
            backtrack(answer, temp, candidates, target - candidates[i], i + 1);
            temp.remove(temp.size() - 1);
        }

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(answer, new ArrayList<>(), candidates, target, 0);

        return answer;
    }
}
// [1, 1, 2, 5, 6, 7, 10]
