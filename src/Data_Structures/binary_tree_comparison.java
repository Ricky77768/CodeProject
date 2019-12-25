package Data_Structures;

public class binary_tree_comparison {
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
        bt.root = new Node(6);
        bt.root.left = new Node(3);
        bt.root.right = new Node(4);

        BinaryTree bt2 = new BinaryTree();
        bt2.root = new Node(6);
        bt2.root.left = new Node(1);
        bt.root.right = new Node(4);

        System.out.println(compareTrees(bt.root, bt2.root));
    }

    public static boolean compareTrees(Node one, Node two) {
        if (one == null && two == null) { return true; }
        if (one == null || two == null) { return false; }

        if (one.value != two.value) {
            return false;
        } else {
            return (compareTrees(one.left, two.left) && compareTrees(one.right, two.right));
        }
    }


}
