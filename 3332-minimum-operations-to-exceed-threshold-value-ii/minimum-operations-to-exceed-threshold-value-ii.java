class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for (int num: nums) {
            pq.add((long)num);
        }

        int operations = 0;
        while (pq.size() > 1) {
            long x = pq.poll();
            long y = pq.poll();
            if (x < k || y < k) {
                pq.add((long)(Math.min(x, y) * 2) + Math.max(x, y));
                operations++;
            } else {
                break;
            }
            
        }

        return operations;
    }
}

/*
[3, 3, 10, 11, ]
1
*/