class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        for (int num: nums) {
            pq.offer(num);
        }
        this.k = k;
    }
    
    public int add(int val) {
       pq.offer(val);
       while (pq.size() - k != 0)
            pq.poll();


       return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */