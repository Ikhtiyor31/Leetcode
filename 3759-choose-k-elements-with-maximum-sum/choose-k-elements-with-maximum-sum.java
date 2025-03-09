class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][3];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
            pairs[i][2] = i;
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        System.out.println(Arrays.deepToString(pairs));

        long[] answer = new long[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && pairs[i][0] == pairs[i-1][0])
                answer[pairs[i][2]] = answer[pairs[i-1][2]];
            else
                answer[pairs[i][2]] = sum;
            
            pq.add(pairs[i][1]);
            sum += pairs[i][1];
            while (pq.size() > k)  {
                sum -= pq.poll();
            }
    
        }

        return answer;
    }
}