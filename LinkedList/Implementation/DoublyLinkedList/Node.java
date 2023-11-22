package LinkedList.Implementation.DoublyLinkedList;

public class Node {
    int val;
    Node next;
    Node prev;

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node next, Node prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}