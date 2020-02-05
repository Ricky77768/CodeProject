package Questions_Other;

import java.io.*;
import java.util.*;

// NOTE: FOR THIS TO WORK, FIRST VERTEX IS NUMBERED AS ZERO
public class simpleMST {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
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

    static class Graph {
        int vertices, edges; // Number of vertices and edges in graph
        Edge[] edgeList; // Contains all edges

        Graph(int v, int e) {
            vertices = v;
            edges = e;

            edgeList = new Graph.Edge[edges];
            for (int i = 0; i < edges; i++) {
                edgeList[i] = new Edge();
            }
        }

        // A class to represent a graph edge
        class Edge implements Comparable<Edge> {
            int start, end, weight;

            public int compareTo(Edge other) {
                return this.weight - other.weight;
            }
        }

        // A class to represent a Subset (For union-find function)
        class Subset {
            int parent, rank;
        }

        public int findRoot(Graph.Subset[] s, int i) {
            if (s[i].parent != i) {
                s[i].parent = findRoot(s, s[i].parent);
            }
            return s[i].parent;
        }

        public void unionByRank(Graph.Subset[] s, int index1, int index2) {
            int root1 = findRoot(s, index1);
            int root2 = findRoot(s, index2);

            if (s[root1].rank > s[root2].rank) {
                s[root2].parent = root1;
            } else if (s[root1].rank < s[root2].rank) {
                s[root1].parent = root2;
            } else {
                s[root1].parent = root2;
                s[root1].rank++;
            }
        }

        public void MST() {
            Edge[] output = new Edge[vertices];
            Subset[] subsets = new Subset[vertices];

            for (int i = 0; i < output.length; i++) {
                output[i] = new Edge();
                subsets[i] = new Subset();
                subsets[i].parent = i;
                subsets[i].rank = 0;
            }

            Arrays.sort(edgeList);
            // Flip array here for Maximum spanning tree

            int numOfEdges = 0; // To keep track how many edges added
            int curIndex = 0; // To keep track of which edge is selected
            Graph.Edge cur;
            while (numOfEdges < vertices - 1) {
                cur = edgeList[curIndex];
                curIndex++;
                int src1 = findRoot(subsets, cur.start);
                int src2 = findRoot(subsets, cur.end);

                // Not in same subset, merge them, else discard it
                if (src1 != src2) {
                    output[numOfEdges] = cur;
                    numOfEdges++;
                    unionByRank(subsets, src1, src2);
                }
            }

            // Output result
            int combinedWeight = 0;
            for (int i = 0; i < output.length - 1; i++) {
                combinedWeight += output[i].weight;
            }
            System.out.println(combinedWeight);

        }
    }

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int v = reader.nextInt(); // vertices
        int k = reader.nextInt();
        int e = v - 1 + (v - k); // edges
        Graph g = new Graph(v, e);

        int index = 1;
        while (index < v) {
            g.edgeList[index - 1].start = index - 1;
            g.edgeList[index - 1].end = index;
            g.edgeList[index - 1].weight = reader.nextInt();
            index++;
        }

        for (int i = 1; i <= v - k; i++) {
            g.edgeList[index - 1].start = i - 1;
            g.edgeList[index - 1].end = i + k - 1;
            g.edgeList[index - 1].weight = 0;
            index++;
        }

        g.MST();
    }

}
