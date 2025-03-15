class Solution {
    public int minCapability(int[] nums, int k) {
        

        int n = nums.length;
        int l = 1;
        int r = Arrays.stream(nums).max().getAsInt();
        int answer = r;
        while (l < r) {
            int midReward = l + (r - l) / 2;
            int possibleOption = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] <= midReward) {
                    possibleOption++;
                    i += 1;
                }
            }
            if (possibleOption >= k) {
                r = midReward;
            } else {
                l = midReward + 1;
            }

           
        }

        return l;
    }
}

/*
[2, 3, 5, 9] k = 2
 i     i
 i        i
    i     i


*/