class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        for (int num: nums) {
            right.put(num, right.getOrDefault(num, 0) + 1);
        }
     
        for (int i = 0; i < n; i++) {
            right.put(nums.get(i), right.get(nums.get(i)) - 1);
            left.put(nums.get(i), left.getOrDefault(nums.get(i), 0) + 1);

            if (left.get(nums.get(i)) * 2 > i + 1&& right.get(nums.get(i)) * 2 > n - i - 1) {
                return i;
            }
        }

        return -1;
    }
}