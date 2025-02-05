class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (Map.Entry<Integer, Integer> entries: map.entrySet()) {
            list.get(entries.getValue()).add(entries.getKey());
        }

        int[] ans = new int[k];
        int j = 0;
        boolean done = false;
        for (int i = n; i >= 0; i--) {
            List<Integer> currList = list.get(i);
            for (int num: currList) {
                ans[j++] = num;
                if (j == k)
                return ans;
              
            }
        }

        return new int[]{};
    }
}