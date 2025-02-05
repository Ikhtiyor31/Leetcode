class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entries : map.entrySet()) {
            pq.add(new int[] { entries.getKey(), entries.getValue() });
            
        }

        int[] ans = new int[k];
        int i = 0;
        while (!pq.isEmpty() && k-- > 0) {
            ans[i++] = pq.poll()[0];
        }

        return ans;
    }
}