class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] array = new int[m][n];

        for(int indice = 0; indice < indices.length; indice++) {
            int r = indices[indice][0];
            int c = indices[indice][1];
            for(int i = 0; i < n; i++) {
                array[r][i] += 1;
            }

            for(int i = 0; i < m; i++) {
                array[i][c] += 1;
            }
        }
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (array[i][j] % 2 != 0) count += 1;
            }
           
        }

        return count;
    }
}
/*
[1, 3, 1]
[1, 3, 1]

[0, 1]
[1, 1]
indices[0] = [0, 0]


[0, 1]
[1, 1]
*/