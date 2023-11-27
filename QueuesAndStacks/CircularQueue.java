package QueuesAndStacks;

// We will consider the items between front and end
// We will play with the front and end
// This will help in remove method to have O(1) time complexity

public class CircularQueue {

    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int end = 0;
    int front = 0;
    int size = 0;

    public CircularQueue(int size) {
        data = new int[size];
    }

    public CircularQueue() {
        this(DEFAULT_SIZE);
    }

    public boolean insert(int item) {
        if (isFull()) {
            System.out.println("Stack is full");
            return false;
        }
        data[end++] = item;
        end = end % data.length;
        size++;
        return true;
    }

    public int remove() throws Exception {

        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        int removed = data[front++];
        front = front % data.length;
        size--;
        return removed;

    }

    protected boolean isFull() {
        return size == data.length;
    }

    protected boolean isEmpty() {
        return size == 0;
    }

    public void display() throws Exception {
        if(isEmpty()) {
            throw new Exception("Empty");
        }
        int i = front;
         do {
            System.out.print(data[i] + "--> ");
            i++;
            i %= data.length;
         } while (i != end);
         System.out.println("End");
    }

    public int peek() {
        return data[front];
    }


}
