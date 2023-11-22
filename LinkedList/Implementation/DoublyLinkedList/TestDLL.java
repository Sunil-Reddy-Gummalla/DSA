package LinkedList.Implementation.DoublyLinkedList;

public class TestDLL {
    public static void main(String[] args) {
        DLL dll = new DLL();
        dll.insertFirst(10);
        dll.insertFirst(20);
        dll.insertLast(30);
        dll.insert(44, 1);
        dll.display();
        // dll.removeFirst();
        // dll.display();
        // dll.removeLast();

        dll.remove(2);
        dll.display();
    }
}
