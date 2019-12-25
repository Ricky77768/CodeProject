package Old_Work;

import java.util.ArrayList;
import java.util.List;

public class int_array_subsets {
    public static void main(String[] args) {
        List<List<Integer>> solutions = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        int[] nums = {1, 2, 3};
        subset(solutions, current, nums, 0);

        for (List<Integer> x : solutions) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }

    }

    public static void subset(List<List<Integer>> solutions, ArrayList<Integer> current, int[] nums, int index) {
        solutions.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            subset(solutions, current, nums, i + 1);
            current.remove(current.size() - 1);
        }

    }

    public static void subsetDuplicate(List<List<Integer>> solutions, ArrayList<Integer> current, int[] nums, int index) {
        solutions.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) { continue; }
            current.add(nums[i]);
            subsetDuplicate(solutions, current, nums, i + 1);
            current.remove(current.size() - 1);
        }

    }

}
