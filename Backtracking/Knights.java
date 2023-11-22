package Backtracking;

public class Knights {

    private static final int BOARD_SIZE = 7;

    public static void main(String[] args) {
        boolean[][] board = new boolean[BOARD_SIZE][BOARD_SIZE];

        System.out.println(getKnights(board, 0));
    }

    private static int getKnights(boolean[][] board, int row) {
        if (row == BOARD_SIZE) {
            //displayBoard(board);
            return 1;
        }

        int count = 0;

        for (int col = 0; col < BOARD_SIZE; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += getKnights(board, row + 1);
                board[row][col] = false;
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {

        if (row - 2 >= 0 && col - 1 >= 0 && board[row - 2][col - 1]) {
            return false;
        }
        if (row - 2 >= 0 && col + 1 < BOARD_SIZE && board[row - 2][col + 1]) {
            return false;
        }
        if (row - 1 >= 0 && col - 2 >= 0 && board[row - 1][col - 2]) {
            return false;
        }
        if (row - 1 >= 0 && col + 2 < BOARD_SIZE && board[row - 1][col + 2]) {
            return false;
        }

        return true;
    }

    public static void displayBoard(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean cell : row) {
                System.out.print(cell ? "K " : "o ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
