class SmallestInfiniteSet {
    private PriorityQueue<Integer> pq;
    private Set<Integer> set;
    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        set = new HashSet<>();
        for (int i = 1; i <= 1000; i++) {
            pq.add(i);
            set.add(i);
        }
    }
    
    public int popSmallest() {
        set.remove(pq.peek());

        return pq.poll();
    }
    
    public void addBack(int num) {
        if (!set.contains(num)) {
            set.add(num);
            pq.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */