class Solution {
    Map<String, Long> memo = new HashMap<>();
    public long maxPoints(int[][] points, int r, int c) {
        if (r == points.length) {
            return 0;
        }

        String key = r + "," + c;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        long maxPoint = 0;
        for (int i = 0; i < points[r].length; i++) {
            long newSum = points[r][i] - (r == 0 ? 0 : Math.abs(c - i));
            maxPoint = Math.max(maxPoint, newSum + maxPoints(points, r + 1, i));
        }
        memo.put(key, maxPoint);
        return maxPoint;
    }


    public long maxPoints(int[][] points) {
    
        //return maxPoints(points, 0, 0);
        int n = points.length;
        int m = points[0].length;
        long[] previousRow = new long[m];
        for (int i = 0; i < m; i++) {
            previousRow[i] = points[0][i];
        }

        for (int r = 0; r < n - 1; r++) {
            long[] leftRunningMax = new long[m];
            long[] rightRunningMax = new long[m];
            long[] currentRow = new long[m];
            leftRunningMax[0] = previousRow[0];
            for (int c = 1; c < m; c++) {
                leftRunningMax[c] = Math.max(leftRunningMax[c - 1] - 1, previousRow[c]);
            }

            rightRunningMax[m - 1] = previousRow[m-1];
            for (int c = m - 2; c >= 0; c--) {
                rightRunningMax[c] = Math.max(rightRunningMax[c + 1] - 1, previousRow[c]);
            }

            for (int c = 0; c < m; c++) {
                currentRow[c] = points[r + 1][c] + Math.max(leftRunningMax[c], rightRunningMax[c]);
            }
            previousRow = currentRow;
        }

        long maxPoint = 0;
        for (int i = 0; i < m; i++) {
            maxPoint = Math.max(maxPoint, previousRow[i]);
        }

        return maxPoint;
    }
}