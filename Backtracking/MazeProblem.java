package Backtracking;

import java.util.Arrays;

public class MazeProblem {
    public static void main(String[] args) {
        // int ans = getMazeCount(3, 2);
        // System.out.println(ans);
        // getMazePath("", 3, 3);
        boolean[][] board = { { true, true, true }, { true, true, true }, { true, true, true } };
        // getMazePathObs("", board, 0, 0);

        int[][] path = new int[board.length][board[0].length];

        allPaths("", board, 0, 0, path, 1);
    }

    // private static void getMazePathObs(String path, boolean[][] board, int r, int
    // c) {
    // if (r == board.length - 1 && c == board[0].length - 1) {
    // System.out.println(path);
    // return;
    // }
    // if (!board[r][c]) {
    // return;
    // }
    // if (r < board.length - 1) {
    // getMazePathObs(path + "D", board, r + 1, c);
    // }

    // if (c < board[0].length - 1) {
    // getMazePathObs(path + "R", board, r, c + 1);
    // }

    // }

    // private static int getMazeCount(int r, int c) {
    // if (r == 1 || c == 1) {
    // return 1;
    // }
    // int left = getMazeCount(r - 1, c);
    // int right = getMazeCount(r, c - 1);
    // return left + right;
    // }

    // private static void getMazePath(String path, int r, int c) {
    // if (r == 1 && c == 1) {
    // System.out.println(path);
    // return;
    // }
    // if (r > 1)
    // getMazePath(path + "D", r - 1, c);
    // if (c > 1)
    // getMazePath(path + "R", r, c - 1);
    // }

    private static void allPaths(String p, boolean[][] board, int r, int c, int[][] path, int step) {
        if (r == board.length - 1 && c == board[0].length - 1) {
            path[r][c] = step;
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            return;
        }
        if (!board[r][c]) {
            return;
        }
        board[r][c] = false;
        path[r][c] = step;
        if (r < board.length - 1) {
            allPaths(p + "D", board, r + 1, c, path, step + 1);
        }

        if (c < board[0].length - 1) {
            allPaths(p + "R", board, r, c + 1, path, step + 1);
        }

        if (r > 0) {
            allPaths(p + "U", board, r - 1, c, path, step + 1);
        }

        if (c > 0) {
            allPaths(p + "L", board, r, c - 1, path, step + 1);
        }

        board[r][c] = true;
        path[r][c] = 0;      

    }
}