class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int targetArrival = times[targetFriend][0];
        Arrays.sort(times, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        TreeSet<Integer> availableChairs = new TreeSet<>();
        int nextChair = 0;
        for (int[] time: times) {
            int arrival = time[0];
            int leave = time[1];

            while (!pq.isEmpty() && pq.peek()[0] <= arrival) {
                availableChairs.add(pq.poll()[1]);
            }
            int currentChair;
            if (!availableChairs.isEmpty()) {
                currentChair = availableChairs.first();
                availableChairs.remove(currentChair);
            } else {
                currentChair = nextChair++;
            }

            pq.offer(new int[]{ leave,  currentChair });

            if (arrival == targetArrival) return currentChair;
        }

        return 0;
    }
}