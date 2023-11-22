package Strings;

public class ReplaceStringChar {

    public static void main(String[] args) {
        String str = "baccard";
        String ans = replaceStringChar(str, "", 'c');
        System.out.println(ans);
    }

    private static String replaceStringChar(String str, String ans, char c) {

        if (str.isEmpty())
            return ans;

        char ch = str.charAt(0);

        if (ch == c) {
            return replaceStringChar(str.substring(1), ans, c);
        } else {
            ans += ch;
            return replaceStringChar(str.substring(1), ans, c);
        }

    }

}
