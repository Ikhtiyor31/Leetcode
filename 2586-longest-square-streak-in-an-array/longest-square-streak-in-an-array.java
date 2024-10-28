class Solution {

    public boolean isPerfectSquareRoot(int num) {
        double sqrt = Math.sqrt(num);
        return Math.floor(sqrt) == sqrt;
    }
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);

        int[] array = new int[nums[nums.length - 1] + 1];
        int maxNum = nums[nums.length - 1] + 1;
        for (int num: nums) {
            array[num] = 1;
        }
        
        
        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            long current = nums[i];
            int count = 0;
            while (array[(int) current] == 1) {
                count++;
                if (1e5 < current * current || maxNum <= current * current) 
                    break;
                current = current * current;
            } 
            longest = (int) Math.max(count, longest);
        }

        return longest > 1 ? longest : - 1;

    }

    
}