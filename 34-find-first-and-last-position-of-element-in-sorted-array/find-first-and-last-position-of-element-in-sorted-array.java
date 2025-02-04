class Solution {

    public int binarySearch(int[] nums, int target) {
        int n =nums.length;
        int l = 0;
        int r = n - 1;
        int ans = n;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return l;
    } 


    public int[] searchRange(int[] nums, int target) {
        
        int first =  binarySearch(nums, target);
        int second = binarySearch(nums, target + 1);
        //System.out.println(first + " " + second);
        if (first <= second - 1) {
            return new int[]{first, second - 1};
        }
        return new int[]{-1, -1};
    }
}