class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums); 
        int answer = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int count = 0;
            for (int j = i; j < n; j++) {
                min  = Math.min(min, nums[j]);
                max =  Math.max(max, nums[j]);
                if (Math.abs(min - max) == 1) {
                    answer = Math.max(answer, Math.abs(j - i + 1));
                }
            }
        }

        return answer;
        
    }
}