package Questions_CCC;
import java.util.Scanner;

public class j2018_4 {
	public static void PrintArray(int[][] input) {
		
		int counter = 0;
		for (int i = 0; i < input.length; i++) {
			for (int i2 = 0; i2 < input.length; i2++) {
				if (counter < input[0].length - 1) {
					System.out.print(input[i][i2] + " ");
					counter += 1;
				}
				else {
					System.out.println(input[i][i2]);
					counter = 0;
				}
			}
		}	
	}
	
	public static int[][] Rotate90CW(int[][] input) {
		int[][] FinalData = new int[input.length][input.length];
	
		for (int i = 0; i < input.length; i++) {
			for (int i2 = 0; i2 < input.length; i2++) {
					FinalData[i2][input.length-i-1] = input[i][i2];
			}
		}
		return FinalData;
	}
	
	 public static void main(String[] args) {
		 Scanner reader = new Scanner(System.in);
		 int array_size = reader.nextInt();
		 int[][] data_set = new int[array_size][array_size];
		 
		 for (int i = 0; i < array_size; i++) {
			 for (int i2 = 0; i2 < array_size; i2++) {
				 data_set[i][i2] = reader.nextInt();
			 }
		 }
		 
		 while (data_set[0][0] > data_set[1][0] || data_set[0][0] > data_set[0][1]) {
			 data_set = Rotate90CW(data_set);
		 }
		 PrintArray(data_set); 
		 reader.close();
	 }	
}

	