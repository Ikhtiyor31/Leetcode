class Solution {
    public void findSubsetSum(int[] nums, int i, List<Integer> list, List<List<Integer>> subsets) {
        if (i == nums.length) {
            return;
        }

        for (int j = i; j < nums.length; j++) {
            list.add(nums[j]);
            subsets.add(new ArrayList<>(list));
            findSubsetSum(nums, j+1, list, subsets);
            list.remove(list.size()-1);
        }
        
    }
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> subsets = new ArrayList<>();
        int sum = 0;
        findSubsetSum(nums, 0, new ArrayList<>(), subsets);
        for (List<Integer> subset: subsets) {
            int result = 0;
            for (int num: subset) {
                result = result ^ num;
            }
            sum += result;
        }
        
        return sum;
    }
}