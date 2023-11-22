package LinkedList.Implementation.DoublyLinkedList;

public class DLL {

    private Node head;
    private int size;

    void insertFirst(int val) {
        if (head == null) {
            head = new Node(val);
            head.prev = null;
            head.next = null;
            size++;
            return;
        }

        Node newNode = new Node(val);
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++;
    }

    void insertLast(int val) {
        if (head == null) {
            head = new Node(val);
            head.prev = null;
            head.next = null;
            size++;
            return;
        }
        Node newNode = new Node(val);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        newNode.prev = temp;
        temp.next = newNode;
        size++;

    }

    void insert(int val, int index) {

        if (index > size) {
            System.out.println("Index out of bounds, We will insert at last Index");
            insertLast(val);
        }

        if (index == 0) {
            insertFirst(val);
        }
        if (index == size - 1) {
            insertLast(val);
        }

        int i = 0;
        Node temp = head;
        while (i < index - 1) {
            temp = temp.next;
        }

        Node newNode = new Node(val);
        newNode.next = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
        size++;

    }

    void removeFirst() {
        if (size == 0) {
            return;
        }
        if (size == 1) {
            head = null;
            size = 0;
            return;
        }
        head = head.next;
        head.prev = null;
        size--;
    }

    void removeLast() {
        if (size == 0) {
            return;
        }
        if (size == 1) {
            head = null;
            size = 0;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        size--;
    }

    void remove(int index) {
        if(index == 0) { 
            removeFirst();
            return;
        }
        if(index >= size-1) {
            removeLast();
            return;
        }

        Node temp = head;

        int i = 0;

        while(i < index-1) {
            temp = temp.next;
            i++;
        }

        temp.next = temp.next.next;
        temp.next.prev = temp;
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

}
