package Questions_Other;
import java.io.*;
import java.util.*;

// Question: https://dmoj.ca/problem/dmopc14c2p5
// Suspected rounding issue, skipped

public class sawmillScheme {

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class Node {
        int index;
        double value;
        boolean visited;
        ArrayList<Node> adj = new ArrayList<>();

        Node(int index) {
            value = 0;
            this.index = index;
            visited = false;
        }
    }

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int lakes = reader.nextInt();
        int connections = reader.nextInt();
        ArrayList<Node> data = new ArrayList<Node>();
        
        for (int i = 0; i < lakes; i++) {
            data.add(new Node(i + 1));
        }

        int n1, n2;
        for (int i = 0; i < connections; i++) {
            n1 = reader.nextInt();
            n2 = reader.nextInt();
            data.get(n1 - 1).adj.add(data.get(n2 - 1));
        }

        data.get(0).value = 1;
        bfs(data.get(0));

        for (Node x : data) {
            if (x.adj.size() == 0) {
                System.out.println(String.format("%.10f", x.value));
            }
        }
    }

    public static void bfs(Node n) {
        Queue<Node> q = new LinkedList<>();
        Node cur;
        q.add(n);
        n.visited = true;

        while (!q.isEmpty()) {
            cur = q.remove();
            double pRiver = cur.value / cur.adj.size();

            for (Node x : cur.adj) {
                if (!x.visited) {
                    x.visited = true;
                    q.add(x);
                }
                x.value += pRiver;
            }
        }
    }

}
