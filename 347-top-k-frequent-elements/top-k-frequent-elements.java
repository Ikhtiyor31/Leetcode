class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
       
        TreeMap<Integer, List<Integer>> listMap = new TreeMap<>(Comparator.reverseOrder());

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (!listMap.containsKey(entry.getValue())) {
                listMap.put(entry.getValue(), new ArrayList<>());
            }
            listMap.get(entry.getValue()).add(entry.getKey());
        }

        int[] answer = new int[k];
        int i = 0;
        for (Map.Entry<Integer, List<Integer>> entry: listMap.entrySet()) {
            List<Integer> list = entry.getValue();
            for (int num: list) {
                answer[i++] = num;
                k--;
                if (k == 0) {
                    return answer;
                }
            }
        }

        return answer;
    }
}