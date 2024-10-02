class Solution {
    public int[] arrayRankTransform(int[] arr) {
       
        Map<Integer, List<Integer>> map = new TreeMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }

            map.get(arr[i]).add(i);
        }

        int[] result = new int[n];
        int rank = 1;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            for (int idx : entry.getValue()) {
                result[idx] = rank;
            }

            rank++;
        }

        return result;
    }
}