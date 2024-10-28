class Solution {

    public boolean isPerfectSquareRoot(int num) {
        double sqrt = Math.sqrt(num);
        return Math.floor(sqrt) == sqrt;
    }
    public int longestSquareStreak(int[] nums) {
        
        Map<Integer, Integer> longestStreak = new HashMap<>();
        Arrays.sort(nums);
        for (int num: nums) {
            if (isPerfectSquareRoot(num) && longestStreak.containsKey((int) Math.sqrt(num))) {
                longestStreak.put(num, longestStreak.get((int) Math.sqrt(num)) + 1);
            } else {
                longestStreak.put(num, 1);
            }
        }
        int longest = 0;
        for (int streak: longestStreak.values()) {
            longest = Math.max(longest, streak);
        }
        return longest != 1 ? longest : - 1;

    }

    
}