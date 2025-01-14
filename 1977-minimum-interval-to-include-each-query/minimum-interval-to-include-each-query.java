class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] copyQueries = Arrays.copyOf(queries, queries.length);
        Arrays.sort(queries);

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (a[1] - a[0]) - (b[1] - b[0]));


        Map<Integer, Integer> map = new HashMap<>();
        int j = 0;
        for (int query: queries) {
            
            while (j < intervals.length && intervals[j][0] <= query) {
                pq.add(intervals[j++]);
            }

            while (!pq.isEmpty() && pq.peek()[1] < query) {
                pq.poll();
            }

            map.put(query, pq.isEmpty() ? -1: pq.peek()[1] - pq.peek()[0] +  1);
        }

        System.out.println(map);
        int[] result = new int[queries.length];
        System.out.println(Arrays.toString(copyQueries));
        int i = 0;
        for (int value: copyQueries) {
            result[i++] = map.get(value);
        }
        return result;
    }
}