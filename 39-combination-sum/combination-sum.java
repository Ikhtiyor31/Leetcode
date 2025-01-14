class Solution {
    public void backtrack(int[] candidates, List<List<Integer>> list, List<Integer> temp, int start, int target) {
        if (target == 0) {
            list.add(new ArrayList<>(temp));
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            backtrack(candidates, list, temp, i, target - candidates[i]);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> list = new ArrayList<>();
        backtrack(candidates, list, new ArrayList<>(), 0, target);
        return list;
    }
}