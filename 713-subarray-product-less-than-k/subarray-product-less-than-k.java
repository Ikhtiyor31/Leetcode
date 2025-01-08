class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int n = nums.length;
        int l = 0;
        int product = 1;
        int answer = 0;
        for (int r = 0; r < n; r++) {
            product *= nums[r];
            while (product >= k) {
                product /= nums[l++];
            }

            answer += r - l + 1;
          
        }


        return answer;
    }
}

/*

2, 3, 4, 4, 2
ans = 15

10, 5, 2, 6

*/