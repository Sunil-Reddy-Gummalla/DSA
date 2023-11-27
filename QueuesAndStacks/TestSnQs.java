package QueuesAndStacks;

import java.util.Stack;

public class TestSnQs {

    public static void main(String[] args) throws Exception {
        // CircularQueue cque = new CircularQueue(5);
        // stack.push(10);
        // stack.push(20);
        // stack.push(30);
        // stack.push(40);
        // stack.push(50);
        // System.out.println(stack.peek());
        // System.out.println(stack.pop());
        // System.out.println(stack.pop());
        // System.out.println(stack.pop());
        // System.out.println(stack.pop());
        // System.out.println(stack.pop());
        // System.out.println(stack.pop());

        // cque.insert(10);
        // cque.insert(20);
        // cque.insert(30);
        // cque.insert(40);
        // cque.insert(50);
        // cque.remove();
        // cque.insert(77);
        // cque.remove();
        // cque.remove();
        // cque.display();        
        //cque.insert(60);
        
        
        ImplQueueWithStack queueWithStack = new ImplQueueWithStack();
        Stack<Integer> stack = new Stack<>();
        CircularQueue queue = new CircularQueue();
        stack.push(10);
        stack.push(20);
        queueWithStack.push(10);
        queueWithStack.push(20);
                queue.insert(10);
        queue.insert(20);
        System.out.println(stack.peek());
        System.out.println(queueWithStack.peek());
        System.out.println(queue.peek());
        System.out.println(stack.size());
                System.out.println(stack.pop());
        System.out.println(queueWithStack.pop());
        System.out.println(queue.remove());
        
    }
    
}
