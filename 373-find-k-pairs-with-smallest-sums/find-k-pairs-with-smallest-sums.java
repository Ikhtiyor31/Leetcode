class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        List<List<Integer>> list = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b)-> {
             int sumCompare = Integer.compare(a[0] + a[1], b[0] + b[1]);
            if (sumCompare != 0) {
                return sumCompare;
            }
            return Integer.compare(a[0], b[0]);
        });
   
        for (int i = 0; i < n1 && i < k; i++) {
            minHeap.offer(new int[]{nums1[i], nums2[0], 0});
        }
        
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            list.add(Arrays.asList(top[0], top[1]));
            int nextIndex = top[2] + 1;
            if (nextIndex < n2) {
                minHeap.offer(new int[]{top[0], nums2[nextIndex], nextIndex});
            }
        }
        
        
        return list;
    }
}