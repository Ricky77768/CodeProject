package Old_Work;

import java.util.Scanner;

public class euclid_algorithm_method_recursion {

	// Method to calculate GCD without recursion
	public static int euclid_method(int number1, int number2) {
		int remainder, factor;

		/*
		 * Two numbers will undergo modular division. number1 will be the result of the
		 * dividing. number 2 will equal to the remainder of the dividing. This process
		 * continues until the second number is 0, and then it will output the first
		 * number as the GCD
		 */
		while (number2 != 0) {
			remainder = number1 % number2;
			factor = number1 / number2;
			number1 = (number1 - remainder) / factor;
			number2 = remainder;
		}
		return number1;
	}

	public static int euclid_recursion(int number1, int number2) {
		int remainder, factor;

		/*
		 * The numbers will do the same operations, except when the method will be
		 * called until the second number becomes zero. Then, it will return number1 as
		 * the result, which will be the output of the method
		 */
		remainder = number1 % number2;
		factor = number1 / number2;
		number1 = (number1 - remainder) / factor;
		number2 = remainder;
		if (number2 == 0) {
			return number1;
		} else {
			return euclid_recursion(number1, number2);
		}
		
	}

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int n1, n2, temp, gcd;

		System.out.println("Please input two numbers to find the GCD:");
		n1 = reader.nextInt();
		n2 = reader.nextInt();

		// Checks if the numbers contains zero
		if (n1 == 0 || n2 == 0) {
			System.out.println("ERROR - Cannot be zero");
			System.exit(0);
		}

		// Switch number orders if the second one is bigger
		if (n1 < n2) {
			temp = n1;
			n1 = n2;
			n2 = temp;
		}

		// Calling method
		gcd = euclid_recursion(1024, 15); // change method here
		System.out.println("GCD: " + gcd);
		reader.close();

	}
}
