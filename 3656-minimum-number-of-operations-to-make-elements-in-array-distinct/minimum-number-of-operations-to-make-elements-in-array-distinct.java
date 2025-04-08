class Solution {
    public boolean checkUnique(int[] nums, int i) {
        Set<Integer> seen = new HashSet<>();
        for (int j = i; j < nums.length; j++) {
            if (seen.contains(nums[j])) return false;
            seen.add(nums[j]);
        }

        return true;
    }
    public int minimumOperations(int[] nums) {
        for (int i = 0; i < nums.length; i += 3) {
            if (checkUnique(nums, i)) {
                System.out.println(i);
                return (i + 1) / 3;
            }
        }

        return (int) Math.round((double) nums.length / 3);
    }
}