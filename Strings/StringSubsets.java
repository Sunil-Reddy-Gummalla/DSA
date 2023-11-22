package Strings;

import java.util.ArrayList;

public class StringSubsets {
    static ArrayList<String> list = new ArrayList<String>();
    public static void main(String[] args) {
        String str = "abc";
        String ans = "";
        getStringSubsets(ans, str);
        System.out.println(list);
    }

    private static void getStringSubsets(String ans, String str) {
        if(str.isEmpty()) {
            list.add(ans);
            return;
        }
        char ch = str.charAt(0);
        getStringSubsets(ans + ch, str.substring(1));
        getStringSubsets(ans, str.substring(1));
    }
    
}
