class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int[][] result = new int[rows * cols][2];
        int direction = 0;
        for (int i = 0, step = 1; i < rows * cols;) {
            for (int j = 0; j < 2; j++) {
                 for (int k = 0; k < step; k++) {
                    if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                        result[i][0] = rStart;
                        result[i][1] = cStart;
                        i++;
                    }
             
                    rStart += dir[direction][0];
                    cStart += dir[direction][1];
                }
                direction = (direction + 1) % 4;
            }
          
            step++;
        }

        return result;
    }
}