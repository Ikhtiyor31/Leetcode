class Solution {
    public void backtrack(int k, int target, List<List<Integer>> list, int current, List<Integer> temp) {
        System.out.println(target);
        
        if (target == 0 && temp.size() == k) {
            list.add(new ArrayList<>(temp));
            return;
        }
       
        if (temp.size() >= k) {
            return;
        }
        if (target < 0) {
            return;
        }

        

        for (int i = current; i <= 9; i++) {
            temp.add(i);
            backtrack(k, target - i, list, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();

        backtrack(k, n, list, 1, new ArrayList<>());

        return list;
    }
}