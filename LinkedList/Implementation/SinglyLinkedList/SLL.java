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

        void display(Node node) {
        Node temp = node;
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
                while (temp.next != null && temp.val == temp.next.val) {
                    temp.next = temp.next.next;
                }
                if (head.val == temp.val) {
                    head = head.next;
                }
                prev.next = temp.next;
                temp = temp.next;
            }
        }

        return head;

    }

    // LeetCode Easy
    // https://leetcode.com/problems/reverse-linked-list/submissions/
    public Node reverseList(Node head) {

        Node reverse = null;
        Node temp = head;
        while (temp != null) {
            Node newNode = new Node(temp.val);
            if (reverse == null) {
                reverse = newNode;
            } else {

                newNode.next = reverse;
                reverse = newNode;

            }
            temp = temp.next;
        }

        return reverse;

    }

    // Trying Recursive Way
    public Node reverseListRec(Node node) {
    
        if (node.next == null) {
            return node;
        }
        Node reverse = null;
        if (node != null) {
            reverse = reverseListRec(node.next);
        }
        node.next = null;
        Node temp = reverse;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;

        return reverse;

    }

    // Leetcode Medium
    // https://leetcode.com/problems/remove-nodes-from-linked-list/submissions/
    // Note: I have used Hint
    // Think in Reverse
    public Node removeNodes(Node head) {

        head = reverseList(head);
        Node temp = head;
        while (temp != null && temp.next != null) {
            if (temp.val > temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return reverseList(head);
    }

    //Leetcode Easy 
    //Merge Two Sorted Linked Lists
    //https://leetcode.com/problems/merge-two-sorted-lists/
    public Node mergeTwoLists(Node list1, Node list2) {

        Node ans = new Node(0);
        Node temp = ans;

        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;

            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        if(list1 == null) {
            temp.next = list2;
        }

                if(list2 == null) {
            temp.next = list1;
        }

        return ans.next;
        
    }
}
