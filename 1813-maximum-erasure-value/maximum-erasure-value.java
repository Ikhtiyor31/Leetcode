class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int res = 0;
        int sum = 0;
        for (int r = 0; r < n; r++) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            sum += nums[r];
            while (map.containsKey(nums[r]) && map.get(nums[r]) > 1) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) map.remove(nums[l]);
                sum -= nums[l];
                l++;
            }
            res = Math.max(res, sum);
        }

        return res;
    }
}