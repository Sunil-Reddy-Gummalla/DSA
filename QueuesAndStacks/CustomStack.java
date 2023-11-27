package QueuesAndStacks;

public class CustomStack {

    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int ptr = -1;

    public CustomStack(int size) {
        data = new int[size];
    }

    public CustomStack() {
        this(DEFAULT_SIZE);
    }

    public boolean push(int item) {
        if(isFull()) {
            System.out.println("Stack is full");
            return false;
        }
        ptr++;
        data[ptr] = item;
        return true;
    }
 
    public int pop() throws Exception {
        if(isEmpty()) {
            throw new Exception("Stack is empty");
        }
        int removed = data[ptr];
        ptr--;
        return removed;
    }

    protected boolean isFull() {
        return ptr == data.length-1;
    }

    private boolean isEmpty() {
        return ptr == -1;
    }

    public int peek() throws Exception {
        if(isEmpty()) {
            throw new Exception("Stack is Empty to find peek");
        }
        return data[ptr];
    }
    
}
