package Questions_CCC;
import java.text.DecimalFormat;
import java.util.*;

// Question: https://dmoj.ca/problem/ccc00s5

public class s2000_5 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        int sheep = reader.nextInt();
        double[] x = new double[sheep];
        double[] y = new double[sheep];
        double[] distance = new double[sheep];
        ArrayList<Integer> resultIndices = new ArrayList<>();

        for (int i = 0; i < sheep; i++) {
            x[i] = reader.nextDouble();
            y[i] = reader.nextDouble();
        }

        double pos = 0;
        while (pos < 1000.00) {
            for (int i = 0; i < sheep; i++) {
                distance[i] = Math.sqrt(Math.pow(Math.abs(pos - x[i]), 2) + Math.pow(y[i], 2));
            }

            if (resultIndices.indexOf(minIndex(distance)) == -1) {
                resultIndices.add(minIndex(distance));
            }

            pos += 0.01;
        }

        for (int i : resultIndices) {
            System.out.println("The sheep at (" + df.format(x[i]) + ", " + df.format(y[i]) + ") might be eaten.");
        }

    }

    public static int minIndex(double[] array) {
        double minValue = array[0];
        int index = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                index = i;
                minValue = array[i];
            }
        }

        return index;
    }

}
