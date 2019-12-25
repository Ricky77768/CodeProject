package Questions_CCC;

import java.util.Scanner;
public class j2011_5_specialCases {
	public static void main(String[] args) {
		
		/*
		int guests = reader.nextInt();
		boolean[][] list = new boolean[guests][guests];
		
		for (int i = 0; i < guests - 1; i++) {
			list[reader.nextInt()][i] = true;
		}
		*/
		
		Scanner reader = new Scanner(System.in);		
		boolean allByMark = true;
		int guests = reader.nextInt();
		int[] list = new int[guests];
		int result = 0;
		
		for (int i = 0; i < list.length - 1; i++) {
			list[i] = reader.nextInt();
		}

		// Case - Only Mark
		if (list.length == 1) {
			System.out.println("1");
			System.exit(0);
		}
		
		// Case - Only 1 Person
		if (list.length == 2) {
			System.out.println("2");
			System.exit(0);
		}
		
		// Case - All invited by mark
		for (int i = 0; i < list.length - 2; i++) {
			if (list[i] != list[i + 1]) {
				allByMark = false;
			}
		}
			
		if (allByMark) {
			for (int i = list.length - 1; i > 0; i--) {
				if (i == list.length - 1) {
					result += i;
				}
				else {
					result *= i;
				}
			}
			System.out.println(result + 2);
			System.exit(0);
		}
		reader.close();
	}
}
