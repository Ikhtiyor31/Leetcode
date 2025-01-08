class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int r = 0;
        int product = 1;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            while (r < n && (product * nums[r]) < k) {
                product *= nums[r];
                answer += r - i + 1;
                r++;
            }
            
            product /= nums[i];
            if (product == 0) {
                product = 1;
            }
            if (r == i) {
                r++;
            }
          
        }


        return answer;
    }
}

/*

2, 3, 4, 4, 2
ans = 15

10, 5, 2, 6

*/