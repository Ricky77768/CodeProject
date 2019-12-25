package Old_Work;

import java.util.Scanner;

public class calculator_v2_with_order {

	// method for removing an element from array & reduce array size
	public static double[] del_element(double[] array, double number) {
		double[] newarray = new double[array.length - 1];
		for (int i = 0; i < array.length; i++) {
			if (i < number) {
				newarray[i] = array[i];
			} else if (i > number) {
				newarray[i - 1] = array[i];
			}
		}
		return newarray;
	}

	// initial variable declarations & instructions
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		double[] numbers = new double[100];
		String[] signs = new String[100];
		int i1 = 0, i2 = 0, next_number = 1, plus_minus = 0, multi_div = 0;
		double result = 0;

		System.out.println("Please enter the numbers and signs, separated by enter");
		System.out.println("Use + - * / for symbols");
		System.out.println("Enter = to finish");

		// Asking for input
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

		// checking if there is only plus/minus, only multi/div, or mix of both
		for (int i = 0; i < i2; i++) {
			switch (signs[i]) {
			case "+":
				plus_minus = plus_minus + 1;
				break;
			case "-":
				plus_minus = plus_minus + 1;
				break;
			case "*":
				multi_div = multi_div + 1;
				break;
			case "/":
				multi_div = multi_div + 1;
				break;
			}
		}

		// only + or -
		if (multi_div == 0) {
			result = result + numbers[0];
			for (int i = 1; i < i1; i++) {
				switch (signs[i - 1]) {
				case "+":
					result = result + numbers[i];
					break;
				case "-":
					result = result - numbers[i];
				}
			}
			System.out.println(result);
			System.exit(0);
		}

		// only * or /
		else if (plus_minus == 0) {
			result = result + numbers[0];
			for (int i = 1; i < i1; i++) {
				switch (signs[i - 1]) {
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
			System.exit(0);
		}

		// both - doing * and /
		else {
			for (int i5 = 1; i5 < i1; i5++) {
				switch (signs[i5 - 1]) {
				case "*":
					numbers[i5] = numbers[i5 - 1] * numbers[i5];
					numbers[i5 - 1] = 0;
					break;
				case "/":
					if (numbers[i5] == 0) {
						System.out.println("ERROR - ILLEGAL OPERATION (Divided by Zero)");
						System.exit(0);
					} else {
						numbers[i5] = numbers[i5 - 1] / numbers[i5];
						numbers[i5 - 1] = 0;
					}
					break;
				default:
					break;
				}
			}

			// both - removing elements of 0.0
			double test = 0.0;

			while (numbers.length > i1 - multi_div) {
				for (int i = 0; i < numbers.length; i++) {
					if (numbers[i] == test) {
						numbers = del_element(numbers, i);
					}
				}
			}

			// both - doing + and -
			int skip_sign = 0;
			String[] f_signs = new String[100];

			for (int i = 0; i < i2; i++) {
				switch (signs[i]) {
				case "+":
					f_signs[i - skip_sign] = signs[i];
					break;
				case "-":
					f_signs[i - skip_sign] = signs[i];
					break;
				default:
					skip_sign = skip_sign + 1;
					break;
				}
			}

			// System.out.println(Arrays.toString(f_signs));
			// System.out.println(Arrays.toString(numbers));

			result = result + numbers[0];
			for (int i = 1; i < plus_minus + 1; i++) {
				switch (f_signs[i - 1]) {
				case "+":
					result = result + numbers[i];
					break;
				case "-":
					result = result - numbers[i];
					break;
				default:
					break;
				}
			}
			System.out.println(result);
			reader.close();
		}
	}
}