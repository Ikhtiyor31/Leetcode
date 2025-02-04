class Solution {

    public int binarySearch(int[] nums, int target) {
        int n =nums.length;
        int l = 0;
        int r = n - 1;
        int ans = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] >= target) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return ans;
    } 

    public int binarySearch2(int[] nums, int target) {
        int n =nums.length;
        int l = 0;
        int r = n - 1;
        int ans = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] <= target) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return ans;
    } 


    public int[] searchRange(int[] nums, int target) {
        
        int first =  binarySearch(nums, target);
        int second = binarySearch2(nums, target);
        //System.out.println(first + " " + second);
        if (first != -1 && second != -1 && nums[first] == target) {
            return new int[]{first, second};
        }
        return new int[]{-1, -1};
    }
}