class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int sum = 0;
        int n = nums.length;
        int k = 0;
        int[] differenceArray = new int[n + 1];
        for (int i = 0; i < n; i++) {
            
            while (sum + differenceArray[i] < nums[i]) {
                k++;
                if (k > queries.length) {
                    return -1;
                }

                int l = queries[k-1][0], r = queries[k-1][1], val = queries[k-1][2];
                if (r >= i) {
                    differenceArray[Math.max(l, i)] += val;
                    differenceArray[r + 1] -= val;
                }
            }
            sum += differenceArray[i];
        }

        return  k;
    }
}

/*
[2, 0, 2] ==> [2, 2, 4]


*/