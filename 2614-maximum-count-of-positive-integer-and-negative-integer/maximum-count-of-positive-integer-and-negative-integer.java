class Solution {
    public int lowerBound(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
         
        }

        return l;
    }

    public int binarySearch2(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
           if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

    public int maximumCount(int[] nums) {
        int n = nums.length;
        if (n == 1 && nums[0] == 0) {
            return 0;
        }
        int pos = lowerBound(nums, 1);
        int posCount = pos == n - 1 ? 0 : n - pos;
        int negCount = lowerBound(nums, 0);
        negCount = negCount == n - 1 ? n : negCount;
        return Math.max(posCount, negCount);
    }
}