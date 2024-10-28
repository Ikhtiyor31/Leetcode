class Solution {

    public boolean isPerfectSquareRoot(int num) {
        double sqrt = Math.sqrt(num);
        return Math.floor(sqrt) == sqrt;
    }
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);

        int[] array = new int[nums[nums.length - 1] + 1];
        for (int num: nums) {
            array[num] = 1;
        }
        
        int count = 0;
        int longest = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int current = nums[i];
            while (isPerfectSquareRoot(current) && array[(int) Math.sqrt(current)] == 1) {
                count++;
                System.out.println(current);
                current = (int) Math.sqrt(current);
                System.out.println(current);
            } 
            longest = (int) Math.max(count, longest);
            count=0;
            
            longest = (int) Math.max(count, longest);
        }

        return longest > 0 ? longest + 1 : - 1;

    }

    
}