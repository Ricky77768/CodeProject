package Questions_Other;
import java.util.*;

// Question: https://leetcode.com/problems/word-ladder/
// Currently 19/40 cases, TLE at 20

public class wordLadder {

    static class Node {
        String value;
        boolean visited;
        ArrayList<Node> adj = new ArrayList<Node>();

        Node(String value) {
            this.value = value;
            visited = false;
        }
    }

    public static void main(String[] args) {
        String begin = "hit"; // Node[] index 0
        String end = "cog";
        List<String> words = new ArrayList<>();
        words.add("hot"); // Node[] index 1
        words.add("dot");
        words.add("dog");
        words.add("lot");
        words.add("log");
        words.add("cog");

        Node[] graph = new Node[words.size() + 1];
        graph[0] = new Node(begin);
        for (int i = 0; i < words.size(); i++) {
            graph[i + 1] = new Node(words.get(i));
        }

        // Check which words are connected with starting word
        // Since this word is not in list, cannot go back to it (Special Case - One way graph)
        for (int i = 0; i < words.size(); i++) {
            if (compareWords(begin, words.get(i))) {
                graph[0].adj.add(graph[i + 1]);
            }
        }

        // Check which words are connected
        for (int i = 0; i < words.size(); i++) {
            for (int j = i + 1; j < words.size(); j++) {
                if (compareWords(words.get(i), words.get(j))) {
                    graph[i + 1].adj.add(graph[j + 1]);
                    graph[j + 1].adj.add(graph[i + 1]);
                }
            }
        }

        // Printing out graph to check if it's correct
        /* for (Node x : graph) {
            System.out.print("Word: " + x.value + " || Connected: ");
            for (Node y : x.adj) {
                System.out.print(y.value + " ");
            }
            System.out.println();
        } */

        // Running BFS to determine shortest path with each entry point from start word
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < graph[0].adj.size(); i++) {
            search(graph[0].adj.get(i), new ArrayList<>(), result, end, 1);
        }
        Collections.sort(result);

        if (result.size() == 0) {
            System.out.println(0);
        } else {
            System.out.println(result.get(0) + 1);
        }
    }

    // Method to check if words can be linked together in graph
    public static boolean compareWords(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }

        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }

    // Modified recursive search to find shortest path
    public static void search(Node current, ArrayList<String> visited, ArrayList<Integer> result, String target, int count) {

        // Printing out path to check
        /* for (String x : visited) {
            System.out.print(x + " ");
        }
        System.out.print(">> ");
        System.out.println(current.value + " << " + count); */

        if (!current.value.equals(target)) {
            visited.add(current.value);
            for (Node x : current.adj) {
                if (!visited.contains(x.value)) {
                    search(x, (ArrayList<String>) visited.clone(), result, target, count + 1);
                }
            }
        } else {
            // System.out.println("^^^ SUCCESS");
            result.add(count);
        }
    }


}
