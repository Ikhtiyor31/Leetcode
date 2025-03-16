class Solution {
    public int majorityElement(int[] nums) {
        int answer = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                if ((num & (1 << i)) != 0) {
                    count += 1;
                }
            }
            if (count > nums.length / 2) {
                answer |= (1 << i);
            }
        }

        return answer;
    }
}

/*
 * 0011
 * 0010
 * 0011
 * 0011
 * 
 */