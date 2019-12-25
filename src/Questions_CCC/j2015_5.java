package Questions_CCC;

import java.util.Scanner;

public class j2015_5 {
	
	private static Scanner reader = new Scanner(System.in);
	private static int ways = 0;
	private static int startPie = reader.nextInt();
	private static int startPeople = reader.nextInt();
	
	public static void main(String[] args) {
		
		// Special Cases
		if (startPeople == 1 || startPie == startPeople) {
			System.out.println("1");
			System.exit(0);
		}
		
		pi(startPeople, startPie, 1);
		System.out.println(ways);
	}
	
	public static boolean pi(int people, int pies, int min) {	
		// Base
		if (people * min > pies) {
			return false;
		}
		
		// Base
		if (people == 1) {
			if (pies >= min) {
				return true;
			}
			else {
				return pi(people + 1, pies + min, min + 1);
			}
		}
		
		// Recursive
		if (pi(people - 1, pies - min, min)) {
			ways++;
		}
		return pi(people, pies, min + 1);
	}
}
