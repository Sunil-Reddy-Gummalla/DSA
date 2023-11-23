package LinkedList.Implementation.SinglyLinkedList;

public class TestLL {

    public static void main(String[] args) {
        SLL list = new SLL();
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.display();
        list.head = list.reverseListRec(list.head);
       list.display();

    }

}
