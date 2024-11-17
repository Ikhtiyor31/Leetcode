class Solution {
    
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0)
                prefixSum[i] = nums[i];
            else 
                prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(prefixSum[i] - k)) {
                count += map.get(prefixSum[i] - k);
            }
            map.put(prefixSum[i], map.getOrDefault(prefixSum[i], 0) + 1);
        }

        return count;
    }
}

/*
nums = [1, 2, 3] k = 3
1 3 6






*/