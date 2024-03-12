import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import javax.swing.tree.TreeNode;

class BFS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        BFSdisplay(tree.getRoot());
    }

    public static void BFSdisplay(Node node) {
        Queue<Node> queue = new ArrayDeque<Node>();
        Deque<TreeNode> list = new ArrayDeque<>();
        if (node == null) {
            return;
        }
        queue.add(node);
        boolean allprinted = false;
        while(!allprinted) {
            Queue<Node> temp = new ArrayDeque<Node>();
            List<Integer> tempAns = new ArrayList<>();
            tempAns.i
            while (!queue.isEmpty()) {
                Node ele = queue.remove();
                tempAns.
                System.out.print(ele.value + " ");
                if(ele.left != null) {
                    temp.add(ele.left);
                }
                if(ele.right != null) {
                    temp.add(ele.right);
                }
            }
            System.out.println();
            queue = temp;
            allprinted = temp.isEmpty();
        }
    }
}