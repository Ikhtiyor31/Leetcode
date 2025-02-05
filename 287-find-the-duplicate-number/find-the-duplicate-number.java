class Solution {
    public int findDuplicate(int[] nums) {
        
        for (int num: nums) {
            if (nums[Math.abs(num)] < 0) {
                return Math.abs(num);
            } 

            nums[Math.abs(num)] = -nums[Math.abs(num)];
            //System.out.println(Arrays.toString(nums));
        }

        return -1;
    }
}