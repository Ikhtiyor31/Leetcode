class Solution {
    public int[] queryResults(int limit, int[][] queries) {

        int answer[] = new int[queries.length];
        Map<Integer, Integer> label = new HashMap<>();
        Map<Integer, Integer> distinct = new HashMap<>();
        int indx = 0;
        for (int[] query : queries) {
            if (label.containsKey(query[0])) {
                distinct.put(label.get(query[0]), distinct.get(label.get(query[0])) - 1);
                if (distinct.get(label.get(query[0])) == 0) {
                    distinct.remove(label.get(query[0]));
                }
            }
            label.put(query[0], query[1]);
            distinct.put(query[1], distinct.getOrDefault(query[1], 0) + 1);
            answer[indx++] = distinct.size();

        }
        return answer;
    }
}

/*
 * 
 * [0, 3, 5, 4, 0, 0]
 * 
 * 4, 5, 3, 4
 * set = 5, 3, 4
 * count = 2
 * 
 * [1, 2, 2, 4, 5, 0]
 * 
 * 1, 2, 2
 * 
 */