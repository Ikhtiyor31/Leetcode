class Solution {
    public int minSwaps(int[] nums, int val) {
        int n = nums.length;
        int totalCount = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == val) totalCount++;
        }

        int windowStart = 0;
        int windowEnd = 0;
        int count = 0;
        while(windowEnd < totalCount) {
            if (nums[windowEnd++] == val) count++;
        }
        int answerMin = n;
        if (totalCount == 0 || totalCount == n)  {
            return 0;
        }
        answerMin = Math.min(answerMin, totalCount - count);
        while(windowEnd < n) {
            if (nums[windowStart++] == val) {
                count--;
            }
            if (nums[windowEnd++] == val) {
                count++;
            }
            answerMin = Math.min(answerMin,  totalCount - count);
        }

        return answerMin;
    }
    public int minSwaps(int[] nums) {
        int firstMin = minSwaps(nums, 0);
        int secondMin = minSwaps(nums, 1);

        return Math.min(firstMin, secondMin);
    }
}

// [0, 1, 0, 1, 0, 1, 0, 0]