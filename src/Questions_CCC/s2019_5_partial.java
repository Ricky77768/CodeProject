package Questions_CCC;
import java.text.DecimalFormat;
import java.util.*;

/**
 * TLEs on Batch 2, Test 30, even with Fast I/O
 */
public class s2019_5_partial {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int size = reader.nextInt();
		int triangleSize = reader.nextInt();
		int k = 1; // Current triangle size
		int loops = 0; // Number of loops ran

		// Initialize
		int[][] data = new int[size][size];
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length; j++) {
				data[i][j] = -1;
			}
		}

		// Read input data into special array structure
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length; j++) {
				if (j > i) {
					i++;
					j = 0;
				}
				data[i][j] = reader.nextInt();
			}
		}

		// Continues to find largest in 3 int pairs, shrinks array until size match
		while (k != triangleSize) {
			for (int i = 0; i < data.length - k; i++) {
				for (int j = 0; j < data.length - k; j++) {
					if (j > i) {
						i++;
						j = 0;
					}
					data[i][j] = findLargest(data[i][j], data[i + 1][j], data[i + 1][j + 1]);
				}
			}

			loops++;
			k++;
		}

		// Output
		double sum = 0;

		for (int i = 0; i < data.length - loops; i++) {
			for (int j = 0; j < data.length - loops; j++) {
				if (j > i) {
					i++;
					j = 0;
				}
				sum += data[i][j];
			}
		}

		System.out.println(new DecimalFormat("#").format(sum));
	}

	public static int findLargest(int x, int y, int z) {
		if (x >= y && x >= z) { return x; }
		if (y >= z) { return y; }
		return z;
	}

}

