package Questions_CCC;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// Problem: https://dmoj.ca/problem/ccc01s3

public class s2001_3 {

    static class Node {
        int value; // A -> 1, Z -> 26
        boolean visited;
        ArrayList<Node> adj = new ArrayList<>();

        Node(int x) {
            value = x;
            visited = false;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            String str = "";

            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        String input = "";
        ArrayList<String> data = new ArrayList<>();

        while (true) {
            input = reader.nextLine();
            if (input.equals("**")) { break; }
            data.add(input);
        }

        // Construct graph
        Node[] points = new Node[27]; // index 0 is filler
        for (int i = 0; i < 27; i++) {
            points[i] = new Node(i);
        }

        for (String x : data) {
            int a = x.charAt(0) - 64;
            int b = x.charAt(1) - 64;
            points[a].adj.add(points[b]);
            points[b].adj.add(points[a]);
        }

        // Solve
        int output = 0;
        for (String x : data) {
            Node[] temp = points.clone();
            int a = x.charAt(0) - 64;
            int b = x.charAt(1) - 64;
            points[a].adj.remove(points[b]);
            points[b].adj.remove(points[a]);

            if (!hasPath(temp[1])) {
                System.out.println(x);
                output++;
            }

            // Add in the missing road
            for (Node y : temp) {
                y.visited = false;
            }
            points[a].adj.add(points[b]);
            points[b].adj.add(points[a]);

        }
        System.out.println("There are " + output + " disconnecting roads.\n");

    }

    public static boolean hasPath(Node start) {
        Queue<Node> q = new LinkedList<>();
        Node cur;
        q.add(start);
        start.visited = true;

        while (!q.isEmpty()) {
            cur = q.remove();

            for (Node x : cur.adj) {
                if (x.value == 2) { return true; }

                if (!x.visited) {
                    x.visited = true;
                    q.add(x);
                }
            }
        }
        return false;
    }

}
