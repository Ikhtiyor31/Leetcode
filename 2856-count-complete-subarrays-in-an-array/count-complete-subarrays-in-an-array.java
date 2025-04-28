class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) set.add(num);
        int targetSize = set.size();
        int completeSubArray = 0;
        for (int start = 0;  start < nums.length; start++) {
            set = new HashSet<>();
            for (int i = start; i < nums.length; i++) {
                set.add(nums[i]);
                if (targetSize == set.size()) completeSubArray++;
            }
           
        }
        return completeSubArray;
    }
}