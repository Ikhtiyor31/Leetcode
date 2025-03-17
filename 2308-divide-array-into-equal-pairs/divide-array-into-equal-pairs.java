class Solution {
    public boolean divideArray(int[] nums) {
        int[] map = new int[501];
        for (int num: nums) {
            map[num] += 1;
        }

        for (int value: map) {
            if (value % 2 == 1) {
                return false;
            }
        }

        return true;
    }
}

/*
nums = [3,2,3,2,2,2]
- each element belongs to exactly one pair 
- elements present in a pair are equal
each element must occur even number of times 
for example, if we have 4, we need to have even number of occurenece of 4 
[2, 2, 3, 3, 4]

*/