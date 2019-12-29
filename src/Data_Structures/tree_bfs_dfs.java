package Data_Structures;
import java.util.*;

public class tree_bfs_dfs {

    static class Node {
        int value;
        boolean visited;
        ArrayList<Node> adj = new ArrayList<>();

        Node(int value) {
            this.value = value;
            visited = false;
        }
    }

    static class Tree {
        Node root;

        Tree() {
            root = null;
        }
    }

    public static void main(String args[]) {
        Tree t = new Tree();
        /*Node n = new Node(1);
        t.root = n;

        Node n1 = new Node(3);
        Node n2 = new Node(2);
        Node n3 = new Node(4);
        Node n11 = new Node(5);
        Node n22 = new Node(6);
        Node n33 = new Node(7);

        n.adj.add(n1);
        n.adj.add(n2);
        n.adj.add(n3);
        n1.adj.add(n11);
        n2.adj.add(n22);
        n3.adj.add(n33);*/

        Node n = new Node(7);
        t.root = n;

        Node n1 = new Node(8);
        Node n11 = new Node(1);
        Node n12 = new Node(4);
        Node n111 = new Node(9);

        n.adj.add(n1);
        n1.adj.add(n11);
        n1.adj.add(n12);
        n11.adj.add(n111);

        System.out.println(dfs(t, 4));
    }

    public static boolean bfs(Tree t, int target) {
        Queue<Node> q = new LinkedList<>();
        Node cur;
        q.add(t.root);
        t.root.visited = true;

        while (!q.isEmpty()) {
            cur = q.remove();
            System.out.println(cur.value);

            if (cur.value == target) {
                return true;
            }

            for (Node x : cur.adj) {
                if (!x.visited) {
                    x.visited = true;
                    q.add(x);
                }
            }
        }

        return false;
    }

    public static boolean dfs(Tree t, int target) {
        Stack<Node> s = new Stack<>();
        Node cur;
        s.push(t.root);

        while (!s.isEmpty()) {
            cur = s.pop();
            System.out.println(cur.value);
            if (cur.value == target) {
                return true;
            }

            if (!cur.visited) {
                cur.visited = true;
                for (Node x : cur.adj) {
                    s.push(x);
                }
            }
        }
        return false;
    }
}
