package PracticeQuestions;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeNumbersInRange {

    public static void main(String[] args) {
        int[] numbers = {0,1,3,4};
        int[] arr = twoSum(numbers, 1);
        System.out.println(Arrays.toString(arr));
    }

    static ArrayList<Integer> primeRange(int M, int N) {
        // code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while (M <= N) {
            if (isPrimeNumber(M)) {
                ans.add(M);
            }
            M++;
        }
        return ans;
    }

    static boolean isPrimeNumber(int n) {
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int rTarget = target - numbers[i];
            int targetIndex = search(numbers, i, numbers.length, rTarget);
            if (targetIndex >= 0) {
                ans[0] = i;
                ans[1] = targetIndex;
                return ans;
            }
        }
        return ans;
    }

    private static int search(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
