package Questions_CCC;

import java.util.Scanner;

public class j2012_3 {
	public static void main(String [] args) {
		Scanner reader = new Scanner(System.in);
		int factor = reader.nextInt();
		int progress1 = 0;;
		
		// input 1
		while (progress1 < factor) {
			for (int i = 0; i < factor; i++) {
				System.out.print("*");
			}

			for (int i = 0; i < factor; i++) {
				System.out.print("x");
			}
			
			for (int i = 0; i < factor; i++) {
				System.out.print("*");
			}
			progress1++;
			System.out.println("");
		}
		
		progress1 = 0;
		
		// input 2
		while (progress1 < factor) {
			for (int i = 0; i < factor; i++) {
				System.out.print(" ");
			}

			for (int i = 0; i < factor; i++) {
				System.out.print("x");
			}
					
			for (int i = 0; i < factor; i++) {
				System.out.print("x");
			}
			progress1++;
			System.out.println("");
		}
		
		progress1 = 0;
		
		// input 3
		while (progress1 < factor) {
			for (int i = 0; i < factor; i++) {
				System.out.print("*");
			}

			for (int i = 0; i < factor; i++) {
				System.out.print(" ");
			}
					
			for (int i = 0; i < factor; i++) {
				System.out.print("*");
			}
			progress1++;
			System.out.println("");
		}
		reader.close();
	}
}
