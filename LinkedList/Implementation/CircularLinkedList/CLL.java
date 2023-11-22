package LinkedList.Implementation.CircularLinkedList;

public class CLL {

    private Node head;
    private Node tail;
    private int size;

    public void insert(int val) {
        Node newNode = new Node(val);
    
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            newNode.prev = tail;
            tail.next = newNode;
            head.prev = newNode;
            tail = newNode;
        }
    
        size++;
    }
    

    void display() {

        Node temp = head;

        do {

            System.out.print(temp.val);

            System.out.print("--> ");

            temp = temp.next;



        } while(temp != head);
        System.out.println("Start");
    }
}


