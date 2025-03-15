class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b-a);
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.peek());
        maxHeap.poll();
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.peek());
            minHeap.poll();
        }
        //System.out.println(minHeap);
        //System.out.println(maxHeap);
    }
    
    public double findMedian() {
        if (minHeap.size() < maxHeap.size()) return maxHeap.peek();
        return (double)(minHeap.peek() + maxHeap.peek()) / 2;
    }
}
/*
1, 2, 3, 4, 5

min_heap = 3
max_heap =  2, 1

*/
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

 