package Data_Structures;

public class binary_tree_balance {
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

    // A balanced tree is one where the difference of depth between both branches from root node >= 1
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new Node(1);
        bt.root.right = new Node(1);
        bt.root.right.right = new Node(1);

        System.out.println(checkBalance(bt.root));
    }

    public static boolean checkBalance(Node node) {
        return Math.abs(getDepth(node.left) - getDepth(node.right)) <= 1;
    }

    public static int getDepth(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(getDepth(node.left), getDepth(node.right));
        }
    }

}