class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairNums = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairNums[i][0] = nums1[i];
            pairNums[i][1] = nums2[i];
        }
        Arrays.sort(pairNums, (a, b) -> b[1] - a[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        long maxScore = 0;
        for (int i = 0; i < n; i++) {
            
            pq.add(pairNums[i][0]);
            if (i < k-1) {
                sum += pairNums[i][0];
            } else {
                sum += pairNums[i][0];
                maxScore = Math.max(maxScore, sum * pairNums[i][1]);
                sum -= pq.poll();
            }
        }

        return maxScore;
    }
}