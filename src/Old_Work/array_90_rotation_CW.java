package Old_Work;

public class array_90_rotation_CW {
	
	public static void PrintArray(int[][] input) {
		int counter = 0;
		for (int i = 0; i < input.length; i++) {
			for (int i2 = 0; i2 < input[0].length; i2++) {
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
		int[][] FinalData = new int[input[0].length][input.length];
	
		for (int i = 0; i < input.length; i++) {
			for (int i2 = 0; i2 < input[0].length; i2++) {
					FinalData[i2][input.length-i-1] = input[i][i2];
			}
		}
		return FinalData;
	}
	
	public static void main(String[] args) {
		int[][] RotatedData = {
							    {1, 2, 3, 4},
							    {5, 6, 7, 8},
							    {9, 10, 11, 12},
							    {13, 14, 15, 16},
							    {17, 18, 19, 20}
							  };
		
		RotatedData = Rotate90CW(RotatedData);
		PrintArray(RotatedData);
	}
	
	
}
