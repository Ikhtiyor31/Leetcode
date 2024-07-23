class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;        
        int zero = 0;
        int answer = 0;
        int l = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zero++;
            }

            while(zero > k && l <= i) {
                if (nums[l] == 0) {
                    zero--;
                }
                l++;
            }
            answer = Math.max(answer, i - l + 1);
        }

        return answer;
    }

}