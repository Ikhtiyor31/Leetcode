class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        if (n == 1) return 1;
        int maxChunk = 0;
        int unSorted = 1;
        int previousMax = 0;
        for (int i = 0; i < n; i++) {
            previousMax = Math.max(previousMax, arr[i]);
            if (previousMax == i) {
                maxChunk++;
            }
        }

        return maxChunk;
    }
}