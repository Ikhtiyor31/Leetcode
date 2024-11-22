class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int answer = 0;
        for (int[] currentRow : matrix) {
           
           int[] flippedRow = new int[m];
           for (int i = 0; i < m; i++) {
                flippedRow[i] = 1 - currentRow[i];
           }

           int count = 0;
           for (int[] compareRow : matrix) {
                if (Arrays.equals(compareRow, currentRow) || Arrays.equals(compareRow, flippedRow)) {
                    count++;
                }
           }

           answer = Math.max(answer, count);
        }

        return answer;
    }   
}

/*
    [0, 1],
    [1, 1]
    
    [1, 1],
    [0, 0]
    
    [[0, 0, 0],
     [0, 0, 1],
     [1, 1, 0]]
     1 1 0
*/