package Questions_CCC;
import java.util.Scanner;

public class j2005_4 {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int input_length = reader.nextInt();
		int input_width = reader.nextInt();
		int input_c_length = reader.nextInt();
		int input_c_width = reader.nextInt();
		int target_step = reader.nextInt();
		int[][] room = makeRoom(input_length, input_width, input_c_length, input_c_width);

		int step = 0;
		// 0 = N, 90 = E, 180 = S, 270 = W
		int dir = 90;
		int row = input_c_length;
		int column = 0;
		boolean left_turn, forward, right_turn;

		while (step != target_step) {

			left_turn = check_left(room, dir, column, row);
			forward = check_forward(room, dir, column, row);
			right_turn = check_right(room, dir, column, row);

			System.out.println("Left Possible: " + left_turn);
			System.out.println("Forward Possible: " + forward);
			System.out.println("Right Possible: " + right_turn);
			System.out.println();

			if (left_turn == true) {
				room[column][row] = 1;
				if (dir == 0) {
					row -= 1;
				}

				if (dir == 90) {
					column -= 1;
				}

				if (dir == 180) {
					row += 1;
				}

				if (dir == 270) {
					column += 1;
				}
				step += 1;
				dir -= 90;
				dir = dir_conversion(dir);
				printArray(room);
			}

			else if (forward == true) {
				room[column][row] = 1;
				if (dir == 0) {
					column -= 1;
				}

				if (dir == 90) {
					row += 1;
				}

				if (dir == 180) {
					column += 1;
				}

				if (dir == 270) {
					row -= 1;
				}
				step += 1;
				printArray(room);
			}

			else if (right_turn == true) {
				room[column][row] = 1;
				if (dir == 0) {
					row += 1;
				}

				if (dir == 90) {
					column += 1;
				}

				if (dir == 180) {
					row -= 1;
				}

				if (dir == 270) {
					column -= 1;
				}
				step += 1;
				dir += 90;
				dir = dir_conversion(dir);
				printArray(room);
			} else {
				break;
			}
		}
		column += 1;
		row += 1;
		System.out.println();
		System.out.println("---Final Coordinates---");
		System.out.println(row);
		System.out.println(column);
		System.out.println("---Final Coordinates---");
		reader.close();
	}

	/*
	 * Purpose: To create a cross-like 2D array with cutoff at the corners Input:
	 * Dimensions of the 2D array, dimensions of the corner cutoffs Output: A 2D
	 * array with cutoff at corners Restriction: Cutoff dimensions cannot be larger
	 * then the array dimensions
	 * 
	 * How it works: It creates a 2D array with given dimensions first, then it
	 * creates the width (vertical) of the cutoff on the width of the 2D array. Then
	 * a if statement scans the width, and creates the length (horizontal) of the
	 * cutoff on each row it detects a "1".
	 */
	public static int[][] makeRoom(int length, int width, int c_length, int c_width) {
		Scanner reader = new Scanner(System.in);

		int[][] method_array = new int[width][length];

		for (int i = 0; i < c_width; i++) {
			method_array[i][0] = 1;
		}

		for (int i = width - 1; i > width - c_width - 1; i--) {
			method_array[i][0] = 1;
		}

		for (int i = 0; i < method_array.length; i++) {
			if (method_array[i][0] == 1) {
				for (int i2 = 0; i2 < c_length; i2++) {
					method_array[i][i2] = 1;
				}

				for (int i2 = length - 1; i2 > length - c_length - 1; i2--) {
					method_array[i][i2] = 1;
				}
			}
		}
		reader.close();
		return method_array;
	}

	/*
	 * Purpose: To convert the direction variable into correct values (to 270 when
	 * N->W, to 0 when W->N) Input: The direction variable ONLY Output: The
	 * corrected variable Restriction: None
	 */
	public static int dir_conversion(int input) {
		if (input == -90) {
			input = 270;
			return input;
		} else if (input == 360) {
			input = 0;
			return input;
		}
		return input;
	}

	/*
	 * (The following comments apply to the next 3 methods) Purpose: To check
	 * whether the character can turn left, right, or go straight through Input: The
	 * direction variable ONLY Output: A boolean that tells whether the character
	 * can do the corresponding actions Restriction: None
	 */

	public static boolean check_left(int[][] map, int dir, int column, int row) {
		if (dir == 0) {
			try {
				if (map[column][row - 1] == 0) {
					return true;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				return false;
			}
		}

		if (dir == 90) {
			try {
				if (map[column - 1][row] == 0) {
					return true;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				return false;
			}
		}

		if (dir == 180) {
			try {
				if (map[column][row + 1] == 0) {
					return true;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				return false;
			}
		}

		if (dir == 270) {
			try {
				if (map[column + 1][row] == 0) {
					return true;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				return false;
			}
		}
		return false;
	}

	public static boolean check_forward(int[][] map, int dir, int column, int row) {

		if (dir == 0) {
			try {
				if (map[column - 1][row] == 0) {
					return true;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				return false;
			}
		}

		if (dir == 90) {
			try {
				if (map[column][row + 1] == 0) {
					return true;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				return false;
			}
		}

		if (dir == 180) {
			try {
				if (map[column + 1][row] == 0) {
					return true;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				return false;
			}
		}

		if (dir == 270) {
			try {
				if (map[column][row - 1] == 0) {
					return true;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				return false;
			}
		}
		return false;
	}

	public static boolean check_right(int[][] map, int dir, int column, int row) {

		if (dir == 0) {
			try {
				if (map[column][row + 1] == 0) {
					return true;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				return false;
			}
		}

		if (dir == 90) {
			try {
				if (map[column + 1][row] == 0) {
					return true;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				return false;
			}
		}

		if (dir == 180) {
			try {
				if (map[column][row - 1] == 0) {
					return true;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				return false;
			}
		}

		if (dir == 270) {
			try {
				if (map[column - 1][row] == 0) {
					return true;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				return false;
			}
		}
		return false;
	}

	/*
	 * Purpose: To print out a 2D array easily Input: A 2D array Output: The inputed
	 * 2D displayed in a grid format Restriction: None
	 */
	public static void printArray(int[][] method_array) {
		for (int i = 0; i < method_array.length; i++) {
			for (int i2 = 0; i2 < method_array[0].length; i2++) {
				System.out.print(method_array[i][i2] + " ");
			}
			System.out.println();
		}
	}
}
