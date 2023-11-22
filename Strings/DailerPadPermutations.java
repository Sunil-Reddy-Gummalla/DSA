package Strings;

import java.util.ArrayList;
import java.util.List;

public class DailerPadPermutations {
    // Declare arr as a class variable
    private static String[] arr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        String digits = "239";
        List<String> ans = digitsPermutation("", digits);
        System.out.println(ans);
    }

    private static List<String> digitsPermutation(String ans, String digits) {
        List<String> outer = new ArrayList<String>();

        if(digits.isEmpty()) {
            List<String> result = new ArrayList<String>();
            result.add(ans);
            return result;
        }

        int ch = Character.getNumericValue(digits.charAt(0));
        String str = arr[ch];

        for(char c : str.toCharArray()) {
            // No need to pass arr as a parameter here
            outer.addAll(digitsPermutation(ans + c, digits.substring(1)));
        }

        return outer;
    }
}
