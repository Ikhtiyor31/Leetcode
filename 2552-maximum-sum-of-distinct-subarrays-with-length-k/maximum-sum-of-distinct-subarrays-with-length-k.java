class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int j = k;
        long max = 0;
        if (map.size() == k) {
            max = sum;
        }
        for (int i = 0; i < n - k; i++, j++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
            }
            sum -= nums[i];
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            sum += nums[j];
            if (map.size() == k) {
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}