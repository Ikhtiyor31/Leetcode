class Solution {
    static class Pair<K, V> {
        K first;
        V second;
        public Pair(K first, V second){
            this.first = first;
            this.second = second;
        }
    }
    public int maxWidthRamp(int[] nums) {
        
        int n = nums.length;
        int max = 0;
        int[] soFarMaxNums = new int[n];
    
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
            Comparator.comparingInt((Pair<Integer, Integer> pair) -> pair.second)
                      .thenComparingInt(pair -> pair.first)
        );
        for (int i = 0; i < n; i++) {
            pq.add(new Pair<>(i, nums[i]));
        }

       
        int minIndex = n;
        while (!pq.isEmpty()) {
                Pair<Integer, Integer> currPair = pq.poll();
                max = Math.max(currPair.first - minIndex, max);
                minIndex = Math.min(minIndex, currPair.first);
            
        }

        return max;
    }
}

