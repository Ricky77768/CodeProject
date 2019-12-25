package Questions_CCC;
import java.util.*;

public class s2017_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int aSum = 0;
        int bSum = 0;
        int result = 0;
        int[] a = new int[n];
        int[] b = new int[n];

        // Read Data
        for (int i = 0; i < n; i++) {
            a[i] = reader.nextInt();
        }

        for (int i = 0; i < n; i++) {
            b[i] = reader.nextInt();
        }

        // Solve
        for (int i = 0; i < n; i++) {
            aSum += a[i];
            bSum += b[i];
            if (aSum == bSum) {
                result = i + 1;
            }
        }
        System.out.println(result);
        reader.close();
    }
}
