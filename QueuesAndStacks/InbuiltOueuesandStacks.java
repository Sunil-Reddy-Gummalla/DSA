package QueuesAndStacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InbuiltOueuesandStacks {
    public static void main(String[] args) {
        System.out.println("Working");
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(10);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        Deque<Integer> deque = new ArrayDeque<Integer>();
        deque.addFirst(10);
        deque.addLast(10);
    }
}