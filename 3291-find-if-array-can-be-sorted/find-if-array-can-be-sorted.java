class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        int prevSetbits = Integer.bitCount(nums[0]);
        int maxSegment = nums[0];
        int minSegment = nums[0];
        int maxPrevSegment = Integer.MIN_VALUE;
        
        for (int i = 1; i < n; i++) {
            int currSetbits = Integer.bitCount(nums[i]);
            if (currSetbits == prevSetbits) {
                maxSegment = Math.max(maxSegment, nums[i]);
                minSegment = Math.min(minSegment, nums[i]);
            } else {
                if (minSegment < maxPrevSegment) {
                    return false;
                }

                maxPrevSegment = maxSegment;
                maxSegment = nums[i];
                minSegment = nums[i];
                prevSetbits = currSetbits;
            }
        }
        if (minSegment < maxPrevSegment) {
            return false;
        }
        return true;
    }
}

/* make the separate groups on contigouos way 

 [8,4,2,16,30,15]
 8, 4, 2   30,15
    1        4
keep track of prev max segment to compare subsequent segment min element
if (sebsequent_min_element < maxPrevSegment) return false;

*/