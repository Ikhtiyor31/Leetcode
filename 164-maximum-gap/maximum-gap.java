class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new TreeMap<>();
        if (n < 2) return 0;
        int maxGap = 0;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int prev = -1;

        for (Map.Entry<Integer, Integer> entries: map.entrySet()) {
            if (prev == -1) {
                prev = entries.getKey();
            } else {
                maxGap = Math.max(maxGap, entries.getKey() - prev);
                prev = entries.getKey();
            }
        }

        return maxGap;
    }
}