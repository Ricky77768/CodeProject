package Questions_CCC;
import java.util.*;

// Question: https://dmoj.ca/problem/ccc00j4

public class j2000_4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        ArrayList<Double> streams = new ArrayList<>();
        ArrayList<Integer> commands = new ArrayList<>();

        int n = reader.nextInt();
        for (int i = 0; i < n; i++) {
            streams.add((double) reader.nextInt());
        }
        reader.nextLine();

        String input = reader.nextLine();
        while (!input.equals("77")) {
            commands.add(Integer.parseInt(input));
            input = reader.nextLine();
        }
        commands.add(77);

        int index, percentage;
        double value;
        for (int i = 0; i < commands.size(); i++) {
            if (commands.get(i) == 99) {
                index = commands.get(i + 1) - 1; // index of stream being split
                value = streams.get(index); // original left stream value
                percentage = commands.get(i + 2); // percentage of flow to left stream

                streams.set(index, value * ((double) percentage / 100));
                streams.add(index + 1, value * ((double) (100 - percentage) / 100));

            } else if (commands.get(i) == 88) {
                index = commands.get(i + 1) - 1; // index of left stream merge to right stream

                streams.set(index + 1, streams.get(index) + streams.get(index + 1));
                streams.remove(index);
            }
        }

        for (double x : streams) {
            System.out.print((int) (x + 0.5) + " ");
        }

        // Todo: Last case is WA

    }
}