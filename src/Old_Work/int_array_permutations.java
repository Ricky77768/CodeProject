package Old_Work;
import java.util.ArrayList;
import java.util.List;

public class int_array_permutations {

    public static void main(String[] args) {
        List<List<Integer>> solutions = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        int[] nums = {1, 2, 2, 3}; // CHANGE HERE
        boolean[] visited = new boolean[nums.length];
        permutateDuplicate(solutions, current, nums, visited); // CHANGE HERE

        for (List<Integer> x : solutions) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }

    // Without Duplicates
    public static void permutate(List<List<Integer>> solutions, ArrayList<Integer> current, int[] nums) {

        if (current.size() == nums.length) {
            solutions.add(new ArrayList<>(current));
        }

        for (int i = 0; i < nums.length; i++) {
            if (current.contains(nums[i])) { continue; }
            current.add(nums[i]);
            permutate(solutions, current, nums);
            current.remove(current.size() - 1);
        }
    }

    // With Duplicates
    public static void permutateDuplicate(List<List<Integer>> solutions, ArrayList<Integer> current, int[] nums, boolean[] visited) {
        if (current.size() == nums.length) {
            solutions.add(new ArrayList<>(current));
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) { continue; }
            current.add(nums[i]);
            visited[i] = true;
            permutateDuplicate(solutions, current, nums, visited);
            current.remove(current.size() - 1);
            visited[i] = false;
        }
    }

}
