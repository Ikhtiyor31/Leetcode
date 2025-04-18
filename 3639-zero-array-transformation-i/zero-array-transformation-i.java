class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        
        int n = nums.length;
        int[] prefixSum = new int[n+1];
        for (int[] query: queries) {
            prefixSum[query[0]]++;
            prefixSum[query[1] + 1]--;
        }

        for (int i = 1; i < n; i++) {
            prefixSum[i] += prefixSum[i - 1];
        }

        for (int i = 0; i < n; i++) {
            if (prefixSum[i] < nums[i]) {
                return false;
            }
        }

        return true;
    }
}

/*
    1,  3
  0   2
    +1    -1

 +1    -1

  1 2


*/