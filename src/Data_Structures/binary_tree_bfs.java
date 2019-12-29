package Data_Structures;

import java.util.*;

public class binary_tree_bfs {

    static class Node {
        int value;
        boolean visited;
        Node parent;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            visited = false;
            parent = null;
            right = null;
            left = null;
        }
    }

    static class BinaryTree {
        Node root;

        BinaryTree() {
            root = null;
        }
    }

    public static void main(String args[]) {
        BinaryTree bt = new BinaryTree();
        bt.root = new Node(6);
        bt.root.left = new Node(3);
        bt.root.left.left = new Node(1);
        bt.root.left.right = new Node(4);
        bt.root.right = new Node(9);
        bt.root.right.left = new Node(7);
        bt.root.right.right = new Node(12);

        System.out.println(bfs(15, bt));
    }

    public static boolean bfs(int value, BinaryTree bt) {
        Queue<Node> q = new LinkedList<Node>();
        Node cur;
        q.add(bt.root);

        while (!q.isEmpty()) {
            cur = q.remove();
            cur.visited = true;

            // System.out.println(cur.value);
            if (cur.value == value) {
                return true;
            }

            if (cur.left != null && !cur.left.visited) {
                cur.left.visited = true;
                q.add(cur.left);
            }

            if (cur.right != null && !cur.right.visited) {
                cur.right.visited = true;
                q.add(cur.right);
            }
        }

        return false;
    }
}
