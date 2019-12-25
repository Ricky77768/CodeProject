package Old_Work;

import java.util.Scanner;

public class factorial_method_recursion {

	public static int factorial_loop(int input) {
		int output = 0;

		output = output + input;
		while (input > 1) {
			output = output * (input - 1);
			input = input - 1;
		}
		return output;
	}

	public static int factorial_recursion(int input) {
		if (input == 0) {
			return 1;
		} else {
			return input * factorial_recursion(input - 1);
		}
	}

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int number, result;

		System.out.println("Input a number to factorial it:");
		number = 7;
		result = factorial_recursion(number); //Switch this line between methods
		System.out.println(result);
		reader.close();
	}
}
