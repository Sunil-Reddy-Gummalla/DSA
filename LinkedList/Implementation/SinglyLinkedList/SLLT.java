package LinkedList.Implementation.SinglyLinkedList;

public class SLLT {

    private Node head;
    private Node tail;
    private int size;

    void addFirst(int val) {
        if (size == 0) {
            head = new Node(val);
            tail = head;
        } else {
            Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    void addLast(int val) {
        if (size == 0) {
            head = new Node(val);
            tail = head;
        } else {
            tail.next = new Node(val);
            tail = tail.next;
        }
        size++;
    }

    void insert(int val, int index) {
        if (index == 0) {
            addFirst(val);
            return;
        }
        if (index == size - 1) {
            addLast(val);
            return;
        }
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Node newNode = new Node(val);
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    void removeFirst() {
        if (size == 0)
            return;
        if (size == 1) {
            head = null;
            tail = null;
            size--;
            return;
        }
        head = head.next;
        size--;
    }

    void removeLast() {
        if (size == 0)
            return;
        if (size == 1) {
            head = null;
            tail = null;
            size--;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        size--;
    }

    void remove(int index) {
        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == size - 1) {
            removeLast();
            return;
        }
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " --> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    int size() {
        return size;
    }

}
