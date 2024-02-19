package PracticeQuestions;

import java.util.Arrays;

public class TriangleArray {

    public static void main(String[] args) {
        long[] array = { 1, 2, 3, 4, 5 };

        System.out.println(Arrays.toString(getTriangle(array, 5)));

    }

    public static long[] getTriangle(long arr[], long n) {
        if (n == 1) {
            return arr;
        }
        long[] ans = new long[(int) (n - 1)];

        for (int i = 0; i < (int) (n - 1); i++) {
            ans[i] = arr[i] + arr[i + 1];
        }
        long[] temp = getTriangle(ans, n - 1);
        System.out.println(Arrays.toString(temp));
        long[] res = new long[temp.length + arr.length];
        for (int i = 0; i < temp.length; i++) {
            res[i] = temp[i];
        }
        for (int i = 0; i < arr.length; i++) {
            res[(int) (temp.length + i)] = arr[i];
        }
        return res;
    }

}
