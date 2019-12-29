package Old_Work;

import java.util.ArrayList;
import java.util.List;

public class int_array_combinations {
    public static void main(String[] args) {
        List<List<Integer>> solutions = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        int[] nums = {1, 2, 3, 4, 5}; // CHANGE HERE
        int target = 7; // CHANGE HERE
        findCombinations(solutions, current, nums, target, 0);

        for (List<Integer> x : solutions) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }

    }

    public static void findCombinations(List<List<Integer>> solutions, ArrayList<Integer> current, int[] nums, int target, int index) {

        if (target == 0) {
            solutions.add(new ArrayList(current));
        }

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            target = target - nums[i];
            findCombinations(solutions, current, nums, target, i + 1);
            target = target + current.remove(current.size() - 1);
        }

    }
}
