class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey((sum % k + k) % k)) {
                answer += map.get((sum % k + k) % k);
            }

            map.put((sum % k + k) % k, map.getOrDefault((sum % k + k) % k, 0) + 1);
        }

        return answer;
    }
}
/*

0  1  2   3   4  5
4, 5, 0, -2, -3, 1
4  9  9   7   4  5
  9/5     
   1  1
     10
   4 5 6
    
*/