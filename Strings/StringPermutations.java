package Strings;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {
    public static void main(String[] args) {
        String str = "hello";
       List<String> ans = stringPermutations("", str);
       System.out.println(ans);
    }

    private static List<String> stringPermutations(String ans, String str) {
        if (str.isEmpty()) {
            List<String> result = new ArrayList<String>();
            result.add(ans);
            return result;
        }
        char ch = str.charAt(0);
        List<String> first = stringPermutations(ans + ch, str.substring(1));
        List<String> second = stringPermutations(ch + ans, str.substring(1));
        first.addAll(second);
        return first;
    }

}
