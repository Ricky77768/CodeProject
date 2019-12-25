package Data_Structures;

import java.util.Stack;

public class binary_tree_traversal {
    static class Node {
        int value;
        Node left, right;

        public Node(int num) {
            value = num;
            left = right = null;
        }
    }

    static class BinaryTree {
        Node root;

        public BinaryTree() {
            root = null;
        }
    }

    public static void recur_printPreOrder(Node node) {
        if (node == null) { return; }

        System.out.print(node.value + " ");
        recur_printPreOrder(node.left);
        recur_printPreOrder(node.right);
    }

    public static void recur_printInOrder(Node node) {
        if (node == null) { return; }

        recur_printInOrder(node.left);
        System.out.print(node.value + " ");
        recur_printInOrder(node.right);
    }

    public static void recur_printPostOrder(Node node) {
        if (node == null) { return; }

        recur_printPostOrder(node.left);
        recur_printPostOrder(node.right);
        System.out.print(node.value + " ");
    }

    public static void iter_printPreOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node node;
        stack.push(root);

        while (!stack.empty()) {
            node = stack.pop();
            if (node != null) {
                System.out.print(node.value + " ");
                stack.push(node.right);
                stack.push(node.left);
            }
        }
    }

    public static void iter_printInOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node node = root;

        while (!stack.empty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            System.out.print(node.value + " ");
            node = node.right;
        }
    }

    public static void iter_printPostOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node node = root;

        while (!stack.empty() || node != null) {
            while (node != null) {
                stack.push(node);
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            if (!stack.empty() && stack.peek() == node) {
                node = node.right;
            } else {
                System.out.print(node.value + " ");
                node = null;
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new Node(6);
        bt.root.left = new Node(3);
        bt.root.left.left = new Node(1);
        bt.root.left.right = new Node(4);
        bt.root.right = new Node(9);
        bt.root.right.left = new Node(7);
        bt.root.right.right = new Node(12);

        System.out.println("Pre Order - Recursion");
        recur_printPreOrder(bt.root);
        System.out.println();

        System.out.println("In Order - Recursion");
        recur_printInOrder(bt.root);
        System.out.println();

        System.out.println("Post Order - Recursion");
        recur_printPostOrder(bt.root);
        System.out.println();

        System.out.println("Pre Order - Iteration");
        iter_printPreOrder(bt.root);
        System.out.println();

        System.out.println("In Order - Iteration");
        iter_printInOrder(bt.root);
        System.out.println();

        System.out.println("Post Order - Iteration");
        iter_printPostOrder(bt.root);
        System.out.println();
    }
}
