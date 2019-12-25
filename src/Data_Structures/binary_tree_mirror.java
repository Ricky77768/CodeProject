package Data_Structures;

public class binary_tree_mirror {
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

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new Node(1);
        bt.root.left = new Node(2);
        bt.root.right = new Node(2);
        bt.root.left.left = new Node(3);
        bt.root.right.left = new Node(3);

        System.out.println(checkSymmetry(bt.root));
    }

    public static boolean checkSymmetry(Node node) {
        if (node == null) {
            return true;
        } else {
            return compare(node.left, node.right);
        }
    }

    public static boolean compare(Node one, Node two) {
        if (one == null && two == null) { return true; }
        if (one == null || two == null) { return false; }

        if (one.value != two.value) {
            return false;
        } else {
            return (compare(one.left, two.right) && compare(one.right, two.left));
        }
    }

}