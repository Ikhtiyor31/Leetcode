class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;    
        Map<Integer, Integer> map = new HashMap<>();



        map.put(0, 1);
        int sum = 0;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                answer += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
       
        return answer;
    }
}