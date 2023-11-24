package LinkedList.Implementation.SinglyLinkedList;

public class TestLL {

    public static void main(String[] args) {
        SLL list = new SLL();
        list.addFirst(8);
        list.addFirst(7);
        list.addFirst(6);
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);

        list.display(list.rotateList(list.head, 2));
    }

}
