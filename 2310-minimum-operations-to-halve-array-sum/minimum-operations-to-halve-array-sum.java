class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<Double>((a, b) -> Double.compare(b, a));
        int operations = 0;
        double sum = 0;
        for (int num: nums) {
            pq.add((double)num);
            sum += num;
        }

        double target = (double)sum / 2;
        ///System.out.println(target);
        while (!pq.isEmpty() && target > 0) {
            target -= (double)pq.peek() / 2;
            pq.add((double)pq.poll() / 2);
            operations++;
        }

        //System.out.println(pq);

        return operations;
    }
}