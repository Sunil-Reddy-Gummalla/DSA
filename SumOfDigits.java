public class SumOfDigits {
    public static void main(String[] args) {
        // int ans = sumOfDigits(12385);
        // System.out.println(ans);
        String ans = reverseDigits(82315);
            System.out.println(ans);
    }

    public static int sumOfDigits(int n) {
        int sum = 0;
        if(n/10 == 0) {
            return n%10;
        }
        return sum + n%10 + sumOfDigits(n/10);
    }

    public static String reverseDigits(int n) {
        String s = "";
        if(n%10 == 0) {return "";}
        s = s+ n%10 + reverseDigits(n/10);
        return s;
    }
}
