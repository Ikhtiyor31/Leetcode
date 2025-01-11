class Solution {
    public boolean checkWinner(int x, int[][] ticTacToe) {
        for (int i = 0; i < 3; i++) {
            int rowX = 0; int colX = 0;
            for (int j = 0; j < 3; j++) {
                if (ticTacToe[j][i] == x) rowX++;
                if (ticTacToe[i][j] == x) colX++;
            }
            if (rowX == 3 || colX == 3) return true;
        }
        int dig1 = 0, dig2 = 0;
        for (int i = 0; i < 3; i++) {
            if (ticTacToe[i][i] == x) {
                dig1++;
            }
            if (ticTacToe[i][2-i] == x) {
                dig2++;
            }
        }
        return dig1 == 3 || dig2 == 3;
    }
    public String tictactoe(int[][] moves) {
        int[][] ticTacToe = new int[3][3];
        int i = 0;
        for (int[] move: moves) {
            if (i % 2 == 0) {
                ticTacToe[move[0]][move[1]] = 1;
            } else {
                ticTacToe[move[0]][move[1]] = 2;
            }
            i++;
        }

        boolean isAWinner = checkWinner(1, ticTacToe);
        boolean isBWinner = checkWinner(2, ticTacToe);

        if (isAWinner) return "A";
        if (isBWinner) return "B";
        if (i == 9) return "Draw";

        return "Pending";
    }
}