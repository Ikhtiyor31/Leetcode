class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) set.add(num);

        if (set.size() == nums.length) return 0;

        int i = 3;
        int operation = 1;
        while (i < nums.length) {
            set = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                set.add(nums[j]);
            }

            if (set.size() == nums.length - i) {
                break;
            }
            operation += 1;

            
          
            i += 3;
       
        }

        return operation;
    }
}