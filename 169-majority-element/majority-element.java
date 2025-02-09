class Solution {
    public int majorityElement(int[] nums) {
        
        int n = nums.length; 
        Arrays.sort(nums);
        int majority = 0;
        int count = 1;
        int answer = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i-1] != nums[i]) {
                count = 1;
            }
            if (count > majority) {
                majority = count;
                answer = nums[i-1];
            }
            count += 1;
            
        }

        return answer;
    }
}