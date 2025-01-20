
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

        Map<Integer, Integer> columnCount = new HashMap<>();
        Map<Integer, Integer> rowCount = new HashMap<>();


        //System.out.println(columnSum);
        //System.out.println(rowSum);

        for (int i = 0; i < arr.length; i++) {
            int[] index = indices.get(arr[i]);
            int r = index[0];
            int c = index[1];
            columnCount.put(c, columnCount.getOrDefault(c, 0)  + 1);
            rowCount.put(r, rowCount.getOrDefault(r, 0) + 1);
            if (columnCount.get(c) == m || rowCount.get(r) == n) {
                return i;
            }
        }

        return -1;

    }
}
// 0, 0 0, 1