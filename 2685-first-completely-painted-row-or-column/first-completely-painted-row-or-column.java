
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, int[]> indices = new HashMap<>();
        int m = mat.length;
        int n = mat[0].length;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                indices.put(mat[r][c], new int[]{r, c});
            }
        }

        Map<Integer, Integer> columnSum = new HashMap<>();
        Map<Integer, Integer> rowSum = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += mat[i][j];
            }
            columnSum.put(i, sum);
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += mat[j][i];
            }
            rowSum.put(i, sum);
        }

        //System.out.println(columnSum);
        //System.out.println(rowSum);

        for (int i = 0; i < arr.length; i++) {
            int[] index = indices.get(arr[i]);
            int r = index[0];
            int c = index[1];
            columnSum.put(r, columnSum.get(r) - mat[r][c]);
            rowSum.put(c, rowSum.get(c) - mat[r][c]);
            if (columnSum.get(r) == 0 || rowSum.get(c) == 0) {
                return i;
            }
        }

        return -1;

    }
}
// 0, 0 0, 1