package Algorithms;

import java.util.Arrays;

// NOTE: FOR THIS TO WORK, FIRST VERTEX IS NUMBERED AS ZERO
public class kruskalsMST {

    static class Graph {
        int vertices, edges; // Number of vertices and edges in graph
        Edge[] edgeList; // Contains all edges

        Graph(int v, int e) {
            vertices = v;
            edges = e;

            edgeList = new Edge[edges];
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

        public int findRoot(Subset[] s, int i) {
            if (s[i].parent != i) {
                s[i].parent = findRoot(s, s[i].parent);
            }
            return s[i].parent;
        }

        public void unionByRank(Subset[] s, int index1, int index2) {
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
            Edge cur;
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

            System.out.println("Following are the edges in " + "the constructed MST");
            for (int i = 0; i < output.length - 1; i++) {
                System.out.println("Edge " + output[i].start + " -> " + output[i].end + " | Weight: " + output[i].weight);
            }

        }
    }

    public static void main(String[] args) {
        int V = 9;  // Number of vertices in graph
        int E = 14;  // Number of edges in graph
        Graph graph = new Graph(V, E);

        graph.edgeList[0].start = 0;
        graph.edgeList[0].end = 1;
        graph.edgeList[0].weight = 4;

        graph.edgeList[1].start = 0;
        graph.edgeList[1].end = 7;
        graph.edgeList[1].weight = 8;

        graph.edgeList[2].start = 1;
        graph.edgeList[2].end = 7;
        graph.edgeList[2].weight = 11;

        graph.edgeList[3].start = 1;
        graph.edgeList[3].end = 2;
        graph.edgeList[3].weight = 8;

        graph.edgeList[4].start = 7;
        graph.edgeList[4].end = 8;
        graph.edgeList[4].weight = 7;

        graph.edgeList[5].start = 6;
        graph.edgeList[5].end = 7;
        graph.edgeList[5].weight = 1;

        graph.edgeList[6].start = 6;
        graph.edgeList[6].end = 8;
        graph.edgeList[6].weight = 6;

        graph.edgeList[7].start = 2;
        graph.edgeList[7].end = 8;
        graph.edgeList[7].weight = 2;

        graph.edgeList[8].start = 2;
        graph.edgeList[8].end = 3;
        graph.edgeList[8].weight = 7;

        graph.edgeList[9].start = 2;
        graph.edgeList[9].end = 5;
        graph.edgeList[9].weight = 4;

        graph.edgeList[10].start = 6;
        graph.edgeList[10].end = 5;
        graph.edgeList[10].weight = 2;

        graph.edgeList[11].start = 3;
        graph.edgeList[11].end = 5;
        graph.edgeList[11].weight = 14;

        graph.edgeList[12].start = 3;
        graph.edgeList[12].end = 4;
        graph.edgeList[12].weight = 9;

        graph.edgeList[13].start = 4;
        graph.edgeList[13].end = 5;
        graph.edgeList[13].weight = 10;

        graph.MST();
    }
}
