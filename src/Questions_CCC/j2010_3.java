package Questions_CCC;

import java.util.Scanner;

public class j2010_3 {
	public static void main(String [] args) {
		Scanner reader = new Scanner(System.in);
		int a = 0;
		int b = 0;
		int choice = 0;
		choice = reader.nextInt();
		
		while (choice != 7) {
			
			if (choice == 1) {
				
				if (reader.next().equals("A")) {
					a = reader.nextInt();
				}
				else {
					b = reader.nextInt();
				}
			}
			
			if (choice == 2) {
				if (reader.next().equals("A")) {
					System.out.println(a);
				}
				else {
					System.out.println(b);
				}
			}
			
			if (choice == 3) {
				if (reader.next().equals("A")) {
					if (reader.next().equals("A")) {
						a = a + a;
					}
					else {
						a = a + b;
					}
				}
				else {
					if (reader.next().equals("A")) {
						b = b + a;
					}
					else {
						b = b + b;
					}
				}
			}
			
			if (choice == 4) {
				if (reader.next().equals("A")) {
					if (reader.next().equals("A")) {
						a = a * a;
					}
					else {
						a = a * b;
					}
				}
				else {
					if (reader.next().equals("A")) {
						b = b * a;
					}
					else {
						b = b * b;
					}
				}
			}
			
			if (choice == 5) {
				if (reader.next().equals("A")) {
					if (reader.next().equals("A")) {
						a = a - a;
					}
					else {
						a = a - b;
					}
				}
				else {
					if (reader.next().equals("A")) {
						b = b - a;
					}
					else {
						b = b - b;
					}
				}
			}
			
			if (choice == 6) {
				if (reader.next().equals("A")) {
					if (reader.next().equals("A")) {
						a = a / a;
					}
					else {
						a = a / b;
					}
				}
				else {
					if (reader.next().equals("A")) {
						b = b / a;
					}
					else {
						b = b / b;
					}
				}
			}
			choice = reader.nextInt();
		}
		reader.close();
	}
}
