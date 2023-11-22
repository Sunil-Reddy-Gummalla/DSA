package Backtracking;

public class Queens {

    private static final int BOARD_SIZE = 7;

    public static void main(String[] args) {
        boolean[][] board = new boolean[BOARD_SIZE][BOARD_SIZE];

        System.out.println(getQueens(board, 0));
    }

    private static int getQueens(boolean[][] board, int row) {
        if (row == BOARD_SIZE) {
            displayBoard(board);
            return 1;
        }

        int count = 0;

        for (int col = 0; col < BOARD_SIZE; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count +=getQueens(board, row + 1);
                board[row][col] = false;
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        int tempRow = row - 1;
        int tempColDown = col - 1;
        int tempColUp = col + 1;

        while (tempRow >= 0) {
            if (tempColDown >= 0 && board[tempRow][tempColDown])
                return false;
            if (tempColUp < BOARD_SIZE && board[tempRow][tempColUp])
                return false;
            tempRow--;

            if (tempColDown >= 0) {
                tempColDown--;
            }

            if (tempColUp < BOARD_SIZE) {
                tempColUp++;
            }
        }

        return true;
    }

    private static void displayBoard(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean cell : row) {
                System.out.print(cell ? "Q " : "X ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
