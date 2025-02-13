class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>(
            Arrays.stream(nums)
            .mapToLong(num -> (long)num)
            .boxed()
            .collect(Collectors.toList())
        );

        int operations = 0;
        while (pq.peek() < k) {
            long x = pq.poll();
            long y = pq.poll();
            if (x < k || y < k) {
                long combined = Math.min(x, y) * 2 + Math.max(x, y);
                pq.add(combined);
                operations++;
            }
            
        }

        return operations;
    }
}

/*
[3, 3, 10, 11, ]
1
*/