package QueuesAndStacks;

public class CustomQueue {

    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int end = -1;

    public boolean insert(int item) {
        if (isFull()) {
            System.out.println("Stack is full");
            return false;
        }
        end++;
        data[end] = item;
        return true;
    }

    public int remove(int item) throws Exception {

        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }

        int removed = data[0];
        for (int i = 1; i < end; i++) {
            data[i - 1] = data[i];
        }
        end--;

        return removed;

    }

    public CustomQueue(int size) {
        data = new int[size];
    }

    public CustomQueue() {
        this(DEFAULT_SIZE);
    }

    protected boolean isFull() {
        return end == data.length - 1;
    }

    protected boolean isEmpty() {
        return end == -1;
    }

    public void display() {

        for (int i = 0; i < end; i++) {
            System.out.print(data[i]);
        }

        System.out.println();

    }

}
