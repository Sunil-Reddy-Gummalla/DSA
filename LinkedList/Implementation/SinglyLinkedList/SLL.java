package LinkedList.Implementation.SinglyLinkedList;

public class SLL {
    Node head;
    private int size;

    void addFirst(int val) {
        if (size == 0) {
            head = new Node(val);
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
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(val);
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
            size--;
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
    // Problems starts here
    // 1) Recursive Insert

    // Note: Use helper method
    public void insertRec(int val, int index) {
        head = recuriveInsert(val, index, head);
    }

    public Node recuriveInsert(int val, int index, Node temp) {
        if (index == 0) {
            Node newNode = new Node(val, temp);
            size++;
            return newNode;
        }
        temp.next = recuriveInsert(val, index - 1, temp.next);

        return temp;

    }
// leetcode medium
// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
    public Node deleteDuplicateNodes() {

        Node temp = head;
        Node prev = temp;
        while (temp != null && temp.next != null) {
            if (temp.val != temp.next.val) {
                prev = prev.next;
                temp = temp.next;
            } else {
                while(temp.next != null && temp.val == temp.next.val) {
                    temp.next = temp.next.next;
                }
                if(head.val == temp.val) {
                    head = head.next;
                }
                prev.next = temp.next;
                temp = temp.next;
            }
        }

        return head;

    }
}
