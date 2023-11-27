package Strings;

import java.util.Stack;

public class ParenthesisProb {

    public static void main(String[] args) {
        String s = "))())(";
        int ans = minInsertions(s);
        System.out.println(ans);
    }

    public static int minInsertions(String s) {

        int closeCount = 0;
        int openCount = 0;
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case '(':
                    stack.push('(');
                    break;
                case ')':
                    if (i + 1 != arr.length && arr[i + 1] == ')' && !stack.isEmpty()) {
                        stack.pop();
                        i++;
                    } else if (i + 1 != arr.length && arr[i + 1] != ')' && !stack.isEmpty()) {
                        closeCount++;
                        stack.pop();
                    } else if (i + 1 != arr.length && arr[i + 1] == ')') {
                        openCount++;
                        i++;
                    } else {
                        if (stack.isEmpty()) {
                            closeCount += 2;
                        } else {
                            stack.pop();
                            closeCount++;
                        }
                    }
                    break;
            }

        }
        return openCount + closeCount + stack.size() * 2;
    }

}
