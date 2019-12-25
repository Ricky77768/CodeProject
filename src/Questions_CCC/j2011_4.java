package Questions_CCC;

import java.util.ArrayList;
import java.util.Scanner;

public class j2011_4 {
	public static void main(String [] args) {
		Scanner reader = new Scanner(System.in);		
		ArrayList<Integer> x = new ArrayList<Integer>();
		ArrayList<Integer> y = new ArrayList<Integer>();
		x.add(0);
		x.add(0);
		x.add(0);
		x.add(1);
		x.add(2);
		x.add(3);
		x.add(3);
		x.add(3);
		x.add(4);
		x.add(5);
		x.add(5);
		x.add(5);
		x.add(6);
		x.add(7);
		x.add(7);
		x.add(7);
		x.add(7);
		x.add(7);
		x.add(6);
		x.add(5);
		x.add(4);
		x.add(3);
		x.add(2);
		x.add(1);
		x.add(0);
		x.add(-1);
		x.add(-1);
		x.add(-1);
		
		y.add(-1);
		y.add(-2);
		y.add(-3);
		y.add(-3);
		y.add(-3);
		y.add(-3);
		y.add(-4);
		y.add(-5);
		y.add(-5);
		y.add(-5);
		y.add(-4);
		y.add(-3);
		y.add(-3);
		y.add(-3);
		y.add(-4);
		y.add(-5);
		y.add(-6);
		y.add(-7);
		y.add(-7);
		y.add(-7);
		y.add(-7);
		y.add(-7);
		y.add(-7);
		y.add(-7);
		y.add(-7);
		y.add(-7);
		y.add(-6);
		y.add(-5);
		
		String function = "";
		int value;
		int currentX = -1;
		int currentY = -5;
		int tempX = -1;
		int tempY = -5;
		
		boolean isSafe = true;
		
		while (true) {
			function = reader.next();
			value = reader.nextInt();
			
			if (function.equals("q")) {
				System.exit(0);
			}
			
			if (function.equals("d")) {
				currentY--;
				// System.out.println("NOW: " + currentX + " " + currentY);
				tempX = currentX;
				tempY = currentY;
				
				for (int i = tempY; i > tempY - value; i--) {
					for (int i2 = 0; i2 < x.size(); i2++) {
						if (currentX == x.get(i2) && currentY == y.get(i2)) {
							isSafe = false;
							// System.out.println("ERROR: " + currentX + " " + currentY);
						}
					}
					x.add(currentX);
					y.add(currentY);
					currentY--;
					// System.out.println("NOW: " + currentX + " " + currentY);
				}
				currentY++;
			}
			
			if (function.equals("u")) {				
				currentY++;
				// System.out.println("NOW: " + currentX + " " + currentY);
				tempX = currentX;
				tempY = currentY;
				
				for (int i = tempY; i < tempY + value; i++) {
					for (int i2 = 0; i2 < x.size(); i2++) {
						if (currentX == x.get(i2) && currentY == y.get(i2)) {
							isSafe = false;
							// System.out.println("ERROR: " + currentX + " " + currentY);
						}
					}
					x.add(currentX);
					y.add(currentY);
					currentY++;
					// System.out.println("NOW: " + currentX + " " + currentY);
				}
				currentY--;
			}
			
			if (function.equals("l")) {
				currentX--;
				// System.out.println("NOW: " + currentX + " " + currentY);
				tempX = currentX;
				tempY = currentY;
				
				for (int i = tempX; i > tempX - value; i--) {
					for (int i2 = 0; i2 < x.size(); i2++) {
						if (currentX == x.get(i2) && currentY == y.get(i2)) {
							isSafe = false;
							// System.out.println("ERROR: " + currentX + " " + currentY);
						}
					}
					x.add(currentX);
					y.add(currentY);
					currentX--;
					// System.out.println("NOW: " + currentX + " " + currentY);
				}
				currentX++;
			}
			
			if (function.equals("r")) {
				currentX++;
				// System.out.println("NOW: " + currentX + " " + currentY);
				tempX = currentX;
				tempY = currentY;
				
				for (int i = tempX; i < tempX + value; i++) {
					for (int i2 = 0; i2 < x.size(); i2++) {
						if (currentX == x.get(i2) && currentY == y.get(i2)) {
							isSafe = false;
							// System.out.println("ERROR: " + currentX + " " + currentY);
						}
					}
					x.add(currentX);
					y.add(currentY);
					currentX++;
					// System.out.println("NOW: " + currentX + " " + currentY);
				}
				currentX--;
			}
			
			
			System.out.print(currentX + " " + currentY);
			if (isSafe) {
				System.out.println(" safe");
			}
			else {
				System.out.println(" DANGER");
				System.exit(0);
			}
			reader.close();
		}
	}	
}

