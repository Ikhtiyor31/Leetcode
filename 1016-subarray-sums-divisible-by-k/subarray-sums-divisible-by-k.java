class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        

        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixSum = 0;
        int count = 0;
        for (int num: nums) {
            prefixSum += num;
            int remainder = (prefixSum % k + k) % k;
            if (map.containsKey(remainder)) {
                count += map.get(remainder);
            }

            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }
}