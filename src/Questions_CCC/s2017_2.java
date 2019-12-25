package Questions_CCC;
import java.util.*;

public class s2017_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = reader.nextInt();
        }

        // Solve
        Arrays.sort(data);
        int index;
        int increment = 0;

        if (data.length % 2 == 0) {
            index = data.length / 2 - 1;
        } else {
            index = data.length / 2;
        }

        try {
            while (true) {
                System.out.print(data[index] + " ");
                increment++;

                // Odd is positive, Even is negative
                if (increment % 2 == 0) {
                    index -= increment;
                } else {
                    index += increment;
                }
            }
        } catch (Exception e) { }

        reader.close();
    }
}
