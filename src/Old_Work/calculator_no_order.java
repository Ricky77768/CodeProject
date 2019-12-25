package Old_Work;

import java.util.Scanner;

public class calculator_no_order {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		double[] numbers = new double[100];
		String[] signs = new String[100];
		int i1 = 0, i2 = 0, next_number = 1;
		double result = 0;

		System.out.println("Please enter the numbers and signs, separated by enter");
		System.out.println("Use + - * / for symbols");
		System.out.println("Enter = to finish");

		String str = " ";
		while (str.charAt(0) != '=') {
			if (reader.hasNextDouble()) {
				if (next_number == 1) {
					numbers[i1] = reader.nextDouble();
					i1 = i1 + 1;
					next_number = 0;
				} else {
					System.out.println("ERROR - INVALID FORMAT (Expected a operation sign)");
					System.exit(0);
				}

			} else if (reader.hasNext("-") || reader.hasNext("\\+") || reader.hasNext("\\*") || reader.hasNext("/")) {
				if (next_number == 0) {
					signs[i2] = reader.next();
					i2 = i2 + 1;
					next_number = 1;
				} else {
					System.out.println("ERROR - INVALID FORMAT (Expected a number)");
					System.exit(0);
				}
			} else {
				str = reader.next();
			}
		}

		if (next_number == 1) {
			System.out.println("ERROR - INVALID FORMAT (Expected a number before equal sign)");
			System.exit(0);
		}

		result = result + numbers[0];

		for (int i = 1; i < i1; i++) {
			switch (signs[i - 1]) {
			case "+":
				result = result + numbers[i];
				break;
			case "-":
				result = result - numbers[i];
				break;
			case "*":
				result = result * numbers[i];
				break;
			case "/":
				if (numbers[i] == 0) {
					System.out.println("ERROR - ILLEGAL OPERATION (Divided by Zero)");
					System.exit(0);
				} else {
					result = result / numbers[i];
					break;
				}
			}
		}
		System.out.println(result);
		reader.close();
	}
}