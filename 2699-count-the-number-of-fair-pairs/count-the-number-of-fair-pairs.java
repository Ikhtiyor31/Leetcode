class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);  
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        long count = 0;
        while (l < r) {
            //System.out.println(l + " " + r);
            if (nums[l] + nums[r] >= lower && nums[l] + nums[r] <= upper) {
                // binary search
                int L = l;
                int R = r;
                int mid = r;
                while (L <= R) {
                    mid = L + (R - L) / 2;
                    if (mid < r && nums[mid] + nums[r] <= upper) {
                        L = mid + 1;
                    } else {
                        R = mid - 1;
                    }
                }
                //System.out.println(L + " - " + l);
                count += (L - l);
                r--;
               
            } else if (nums[l] + nums[r] > upper) {
                r--;
            } else {
                l++;
            }
           
        }

        return count;
    }
}

/*
nums = [0, 1, 4, 4, 5, 7], lower = 3, upper = 6
// first find two numbers that add up to val withing the range of lower and up
 

 [1, 2, 5, 7, 9] 11
 [5,5,5,7,7]

*/