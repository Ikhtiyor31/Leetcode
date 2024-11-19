class Solution {
    public int shortestSubarray(int[] nums, int k) {
   
        PriorityQueue<Pair<Long, Integer>> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a.getKey(), b.getKey())
        );
        long cumulativeSum = 0;
        int n = nums.length;
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            cumulativeSum += nums[i];
            if (cumulativeSum >= k) {
                shortest = Math.min(shortest, i + 1);
            }

            while (!pq.isEmpty() && cumulativeSum - pq.peek().getKey() >= k) {
                shortest = Math.min(shortest, i - pq.peek().getValue());
                pq.poll();
            }

            pq.offer(new Pair<>(cumulativeSum, i));
        }


        return shortest == Integer.MAX_VALUE ? -1: shortest;

    }
}

/*
nums = [2, -1, 2, 1]
{2, 0}, {1, 1}, {3, 2}

nums = [1, 2, 3, 1]
{1, 0}, {3, 1}, {}



*/