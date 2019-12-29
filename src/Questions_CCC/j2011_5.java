package Questions_CCC;

// Question: https://dmoj.ca/problem/ccc11j5

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class j2011_5 {

    static class Node {
        int value;
        ArrayList<Node> adj = new ArrayList<>();

        Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        Node[] graph = new Node[n]; // Index n - 1 is Mark, Index 0 is person 1

        for (int i = 0; i < n; i++) {
            graph[i] = new Node(i + 1);
        }

        for (int i = 0; i < n - 1; i++) {
            graph[reader.nextInt() - 1].adj.add(graph[i]);
        }

        // Test code for graph
        /* for (Node x : graph) {
            System.out.print("Person: " + x.value + " || Connected: ");
            for (Node y : x.adj) {
                System.out.print(y.value + " ");
            }
            System.out.println();
        } */

        // All combinations, checking one by one to see if it's possible
        // If removing one person, must also remove all of connected people
        int[] nums = new int[n - 1];
        List<List<Integer>> solutions = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            nums[i] = i + 1;
        }
        findCombinations(solutions, new ArrayList<>(), nums, 0);

        int result = 0;
        for (int i = 0; i < solutions.size(); i++) {
            if (isValid(solutions.get(i), graph)) {
                result++;
            }
        }

        System.out.println(result);
    }

    public static void findCombinations(List<List<Integer>> solutions, ArrayList<Integer> arr, int[] nums, int index) {
        solutions.add((List<Integer>) arr.clone());

        for (int i = index; i < nums.length; i++) {
            arr.add(nums[i]);
            findCombinations(solutions, arr, nums, i + 1);
            arr.remove(arr.size() - 1);
        }
    }

    // Method to check if this combination of removed people is ok
    public static boolean isValid(List<Integer> combination, Node[] graph) {
        /* for (int x : combination) {
            System.out.print(x + " ");
        } */

        for (int x : combination) {
            for (Node y : graph[x - 1].adj) {
                if (!combination.contains(y.value)) {
                    // System.out.println (">>> False");
                    return false;
                }
            }
        }

        // System.out.println(">>> true");
        return true;
    }

}
