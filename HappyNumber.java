public class HappyNumber {
    public static boolean isHappy(int n) {
        while (n != 1 && n != 4) {
            n = getNext(n);
        }
        return n == 1;
    }

    private static int getNext(int num) {
        int totalSum = 0;
        while (num > 0) {
            int digit = num % 10;
            num /= 10;
            totalSum += digit * digit;
        }
        return totalSum;
    }

    public static void main(String[] args) {
        int numberToCheck = 55;
        boolean result = isHappy(numberToCheck);
        System.out.println(numberToCheck + " is a happy number: " + result);
    }
}
