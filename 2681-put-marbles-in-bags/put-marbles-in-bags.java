class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        if (k == 1 || n == 1) 
            return 0;
        int[] pairWeights = new int[n-1];
        for (int i = 0; i < n - 1; i++) {
            pairWeights[i] = weights[i] + weights[i+1];
        }

        Arrays.sort(pairWeights, 0, n - 1);
        long answer = 0;
        long sumLastK = 0;
        long sumFirstK = 0;
        for (int i = 0; i < k - 1; i++) {
            sumLastK += pairWeights[n-2-i];
            sumFirstK += pairWeights[i];
        }

        long maxScore = weights[0] + weights[n-1] + sumLastK;
        long minScore = weights[0] + weights[n-1] + sumFirstK;

        return maxScore - minScore;
    }
}