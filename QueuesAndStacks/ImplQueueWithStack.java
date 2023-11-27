package QueuesAndStacks;

import java.util.Stack;

public class ImplQueueWithStack {

    Stack<Integer> stack = new Stack<>();
    public void push(int value) {
        stack = helper(stack, value);
    }

    private Stack<Integer> helper(Stack<Integer> stack2, int value) {
        if(stack2.size() == 0) {
            stack2.push(value);
            return stack2;
        }
        int storedValue = stack2.pop();
        helper(stack2, value);
        stack2.push(storedValue);
        return stack2;
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

}