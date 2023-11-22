package Backtracking;

public class SudokuSolver {
    public static void main(String[] args) {

        int[][] board = {
            {7, 0, 0, 0, 0, 0, 2, 0, 0},
            {4, 0, 2, 0, 0, 0, 0, 0, 3},
            {0, 0, 0, 2, 0, 1, 0, 0, 0},
            {3, 0, 0, 1, 8, 0, 0, 9, 7},
            {0, 0, 9, 0, 7, 0, 6, 0, 0},
            {6, 5, 0, 0, 3, 2, 0, 0, 1},
            {0, 0, 0, 4, 0, 9, 0, 0, 0},
            {5, 0, 0, 0, 0, 0, 1, 0, 6}
        };
        
        if(solveSudoko(board)) {
            displayBoard(board);
        } else {
            System.out.println("Sudoko failed to solve");
        }

    }

    private static void displayBoard(int[][] board) {

        for(int[] row: board) {
            for(int num: row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }

    private static boolean solveSudoko(int[][] board) {

        int n = board.length;
        int row = -1;
        int col = -1;
        boolean emptyExsists = true;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 0) {
                    row = i;
                    col = j;
                    emptyExsists = false;
                    break;
                }
            }
            if(!emptyExsists) break;
        }

        if(emptyExsists) {
            return true;
        }

        for(int i = 1; i <=n; i++) {
            if(isSafe(board, row, col, i)) {
                board[row][col] = i;
                if(solveSudoko(board)) {
                    return true;
                } else {
                board[row][col] = 0;
                }

            }
        }



        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col, int number) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == number || board[i][col] == number) {
                return false;
            }
        }
        int sqrt = (int) Math.sqrt(board.length);
        int startRow = row - row % sqrt;
        int startCol = col - col % sqrt;
        for (int i = startRow; i < startRow + sqrt; i++) {
            for (int j = startCol; j < startCol + sqrt; j++) {
                if (board[i][j] == number) {
                    return false;
                }
            }
        }
        return true;
    }
}
