package Questions_CCC;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// Question: https://dmoj.ca/problem/ccc06j4

public class j2006_4 {

    static class ToDo {
        boolean completed;
        ArrayList<Integer> preReq; // What task # need to be done before this, empty = ok to do now

        ToDo(ArrayList<Integer> preReq) {
            this.preReq = preReq;
            completed = false;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> solution = new ArrayList<>();
        ToDo[] list = new ToDo[8]; // Index 0 is a filler Object, index 1 equals task 1
        list[0] = new ToDo(new ArrayList<>());
        list[1] = new ToDo(new ArrayList<>(Arrays.asList(2)));
        list[2] = new ToDo(new ArrayList<>());
        list[3] = new ToDo(new ArrayList<>());
        list[4] = new ToDo(new ArrayList<>(Arrays.asList(1, 3)));
        list[5] = new ToDo(new ArrayList<>(Arrays.asList(3)));
        list[6] = new ToDo(new ArrayList<>());
        list[7] = new ToDo(new ArrayList<>(Arrays.asList(1)));

        // Extra constraints
        Scanner reader = new Scanner(System.in);
        int n1 = 1, n2;

        while (true) {
            n1 = reader.nextInt();
            n2 = reader.nextInt();
            if (n1 == 0) { break; }
            list[n2].preReq.add(n1);
        }

        int index = 1;
        while (index < 8) {
            if (!list[index].completed && list[index].preReq.isEmpty()) {
                list[index].completed = true;
                solution.add(index);

                // Remove this task from other preReqs
                for (ToDo x : list) {
                    if (x.preReq.contains(index)) {
                        x.preReq.remove(Integer.valueOf(index));
                    }
                }
                index = 1;

            } else {
                index++;
            }
        }

        if (solution.size() != 7) {
            System.out.println("Cannot complete these tasks. Going to bed.");
        } else {
            for (int x : solution) {
                System.out.print(x + " ");
            }
        }
    }

}
