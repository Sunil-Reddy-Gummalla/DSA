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

    // Leetcode Easy
    // Merge Two Sorted Linked Lists
    // https://leetcode.com/problems/merge-two-sorted-lists/
    public Node mergeTwoLists(Node list1, Node list2) {

        Node ans = new Node(0);
        Node temp = ans;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;

            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        if (list1 == null) {
            temp.next = list2;
        }

        if (list2 == null) {
            temp.next = list1;
        }

        return ans.next;

    }

    // LeetCode Medium
    public Node reverseBetween(Node node, int left, int right) {
        if (node == null || node.next == null) {
            return node;
        }
        if (left == right) {
            return node;
        }
        Node temp = node;
        int leftIndex = left;
        int rightIndex = right;

        for (int i = 1; i < leftIndex - 1; i++) {
            temp = temp.next;
        }

        Node reverseStart = temp.next;
        temp.next = null;

        // Lets Find Reverse Start End

        Node node1 = reverseStart;

        for (int i = leftIndex - 1; i < rightIndex - 1; i++) {
            node1 = node1.next;
        }

        Node arNode = node1.next;

        node1.next = null;

        Node reversed = reverseList(reverseStart);

        // Now Merge all the Nodes and Return
        return addAllNodes(head, reversed, arNode);

    }

    private Node addAllNodes(Node start, Node middle, Node end) {
        Node tempM = middle;
        while (tempM.next != null) {
            tempM = tempM.next;
        }
        tempM.next = end;
        Node tempS = start;
        while (tempS.next != null) {
            tempS = tempS.next;
        }
        tempS.next = middle;
        display(start);
        return start;
    }

    public void reorderList(Node head) {
        // find middle element
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the second half of the list starting from the middle
        Node prev = null;
        while (slow != null) {
            Node temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        // Merge two halves
        Node p1 = head;
        Node p2 = prev;
        while (p1 != null) {
            Node next1 = p1.next;
            Node next2 = p2.next;
            p1.next = p2;
            p2.next = next1;
            p1 = next1;
            p2 = next2;
        }
    }

    // Reverse in K Nodes
    public void reverseKNodes(Node node, int k) {
        if (node == null || node.next == null) {
            return;
        }

        Node prev = null;
        Node curr = node;
        Node ans = new Node(0);
        int j = k;

        while (curr != null && j == k) {
            j = 0;
            for (int i = 0; (i < k) && (curr != null); i++) {
                Node nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }

            Node temp = ans;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = prev;
            prev = null;
            Node currTemp = curr;

            while (currTemp.next != null) {
                j++;
                currTemp = currTemp.next;
                if (j == k)
                    break;
            }
        }

        if (j < k) {
            Node temp = ans;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = curr;

        }

    }

    // Rotate the List with K times to the right

    public Node rotateList(Node node, int k) {
        if (node == null || node.next == null || k <= 0) {
            return node;
        }

        // finding the length of the list

        Node temp = node;
        int length = 1;
        while (temp.next != null) {
            length++;
            temp = temp.next;
        }

        temp.next = node;

        // No of Rotations needed

        int rotations = k % length;

        int nodesToSkip = length - rotations;

        Node newNode = node;

        for (int i = 0; i < nodesToSkip - 1; i++) {
            newNode = newNode.next;
        }

        node = newNode.next;
        newNode.next = null;

        return node;

    }
}
