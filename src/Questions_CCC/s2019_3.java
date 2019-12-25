package Questions_CCC;

import java.util.Scanner;

public class s2019_3 {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int[][] numbers = new int[3][3];
		boolean[][] isUnknown = new boolean[3][3]; // Boolean array to determine which terms are not solved
		boolean solved = false; // Boolean to determine if the square is solved
		int factor = 0; // The common difference between each term when guessing
		
		// Read Data
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (reader.hasNextInt() || reader.hasNext("X")) {
					if (reader.hasNextInt()) {
						numbers[i][j] = reader.nextInt();
					} else {
						isUnknown[i][j] = true;
						reader.next();
					}
				}
			}
		}
		
		// When a square is completed incorrectly, the solving process repeats with a new difference factor
		while (!solved) {	
			
			// Creates new and unused sets of array to attempt to solve again
			int[][] C_numbers = new int[3][3];
			boolean[][] C_isUnknown = new boolean[3][3];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					C_numbers[i][j] = numbers[i][j];
					C_isUnknown[i][j] = isUnknown[i][j];
				}
			}
			factor++;
			solved = solve(C_numbers, C_isUnknown, factor);
		} 
		
		reader.close();
	}
	
	// Begins Solving
	public static boolean solve(int[][] numbers, boolean[][] isUnknown, int factor) {
		boolean modified = false; // Boolean to check if anything has been changed
		
		// Repeat solving process until the 
		while (!checkCompletion(isUnknown)) {
			modified = false;
			
			// Check through each row/col with two terms, and solve the unknown term
			if (checkOneUnknown(numbers, isUnknown, 0, 0)) { modified = true; }
			if (checkOneUnknown(numbers, isUnknown, 1, 0)) { modified = true; }
			if (checkOneUnknown(numbers, isUnknown, 2, 0)) { modified = true; }
			if (checkOneUnknown(numbers, isUnknown, 0, 1)) { modified = true; }
			if (checkOneUnknown(numbers, isUnknown, 1, 1)) { modified = true; }
			if (checkOneUnknown(numbers, isUnknown, 2, 1)) { modified = true; }
			
			// Proceed to here if nothing can be solved
			if (!modified) {
				
				// Find to number of unknown terms
				int unknowns = 0;
				for (boolean[] x : isUnknown) {
					for (boolean y : x) {
						if (y) { unknowns++; }
					}
				}
				
				// Case: 9 Unknowns, any array will do
				if (unknowns == 9) {
					System.out.println("0 0 0");
					System.out.println("0 0 0");
					System.out.println("0 0 0");
					System.exit(0);
				}
				
				// Case: 8 Unknowns, find the known term and then repeat it throughout the square
				if (unknowns == 8) {
					int value = 0;
					
					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {
							if (!isUnknown[i][j]) {
								value = numbers[i][j];
							}
						}
					}
					
					System.out.println(value + " " + value + " " + value);
					System.out.println(value + " " + value + " " + value);
					System.out.println(value + " " + value + " " + value);
					System.exit(0);
				}
				
				/* 
				 * Case: 7 Unknowns 
				 * Find the known terms and fill their respective row with that number,
				 * then solve with two known terms.
				 * 
				 * If row filling fails, fill col in a similar fashion.
				 * 
				 * If col filling also fails, proceed to guessing.
				 */
				
				// Creating temporary arrays to attempt to solve to prevent original getting modified
				if (unknowns == 7) {
					int[][] A_numbers = new int[3][3];
					boolean[][] A_isUnknown = new boolean[3][3];
					int[][] B_numbers = new int[3][3];
					boolean[][] B_isUnknown = new boolean[3][3];
					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {
							A_numbers[i][j] = numbers[i][j];
							A_isUnknown[i][j] = isUnknown[i][j];
							B_numbers[i][j] = numbers[i][j];
							B_isUnknown[i][j] = isUnknown[i][j];
						}
					}
					
					// ----- Horizontal Fill Attempt -----
					int value = 0;
					int row = 0;
					
					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {
							if (!A_isUnknown[i][j]) {
								value = A_numbers[i][j];
								row = i;
								
								for (int k = 0; k < 3; k++) {
									A_numbers[row][k] = value;
									A_isUnknown[row][k] = false;
								}
							}
						}
					}
					checkOneUnknown(A_numbers, A_isUnknown, 0, 0);
					checkOneUnknown(A_numbers, A_isUnknown, 1, 0);
					checkOneUnknown(A_numbers, A_isUnknown, 2, 0);
					checkOneUnknown(A_numbers, A_isUnknown, 0, 1);
					checkOneUnknown(A_numbers, A_isUnknown, 1, 1);
					checkOneUnknown(A_numbers, A_isUnknown, 2, 1);
					
					
					// Verify if the solved square is valid
					if (verify(A_numbers)) {
						System.out.println(A_numbers[0][0] + " " + A_numbers[0][1] + " " + A_numbers[0][2]);
						System.out.println(A_numbers[1][0] + " " + A_numbers[1][1] + " " + A_numbers[1][2]);
						System.out.println(A_numbers[2][0] + " " + A_numbers[2][1] + " " + A_numbers[2][2]);
						System.exit(0);
					}
					
					// ----- Vertical Fill Attempt -----
					int col = 0;
					
					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {
							if (!B_isUnknown[i][j]) {
								value = B_numbers[i][j];
								col = j;
								
								for (int k = 0; k < 3; k++) {
									B_numbers[k][col] = value;
									B_isUnknown[k][col] = false;
								}
							}
						}
					}
					checkOneUnknown(B_numbers, B_isUnknown, 0, 0);
					checkOneUnknown(B_numbers, B_isUnknown, 1, 0);
					checkOneUnknown(B_numbers, B_isUnknown, 2, 0);
					checkOneUnknown(B_numbers, B_isUnknown, 0, 1);
					checkOneUnknown(B_numbers, B_isUnknown, 1, 1);
					checkOneUnknown(B_numbers, B_isUnknown, 2, 1);
					
					// Verify if the solved square is valid
					if (verify(B_numbers)) {
						System.out.println(B_numbers[0][0] + " " + B_numbers[0][1] + " " + B_numbers[0][2]);
						System.out.println(B_numbers[1][0] + " " + B_numbers[1][1] + " " + B_numbers[1][2]);
						System.out.println(B_numbers[2][0] + " " + B_numbers[2][1] + " " + B_numbers[2][2]);
						System.exit(0);
					}
					
					// If none of them works, proceed to guessing method
					modified = guessByFactor(numbers, isUnknown, factor);
				}
				
				
				// Case: Less then 7 Unknowns, Guess Method
				if (unknowns < 7) {
					modified = guessByFactor(numbers, isUnknown, factor);
				}
			}
		}
		
		// Verify to the solved square is valid
		if (verify(numbers)) {
			System.out.println(numbers[0][0] + " " + numbers[0][1] + " " + numbers[0][2]);
			System.out.println(numbers[1][0] + " " + numbers[1][1] + " " + numbers[1][2]);
			System.out.println(numbers[2][0] + " " + numbers[2][1] + " " + numbers[2][2]);
			System.exit(0);
		} else {
			return false;
		}
		
		return true;
	}
	
	/*
	 * Finds the first unknown term, and check if there is a known terms in the horizontal
	 * or vertical relationship. Then, it fills the unknown term with respect to its relative
	 * location of the known term and the factor.
	 */
	public static boolean guessByFactor(int[][] numbers, boolean[][] isUnknown, int factor) {
		// Integers to record the first unknown index
		int row = 0;
		int col = 0;
		
		// The type of guessing of the unknown term (0 = horizontal, 1 = vertical)
		int type = -1;
		
		// The known term's index, (row/col is based on the type)
		int knownIndex = 0;
				
		// Finds the first unknown index
		loops1:
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (isUnknown[i][j]) {
					row = i;
					col = j;
					break loops1;
				}
			}
		}
		
		loops2:
		while (true) {
			
			// Check if the known term is on horizontal
			for (int i = 0; i < 3; i++) {
				if (!isUnknown[row][i]) {
					knownIndex = i;
					type = 0;
					break loops2;
				}
			}
			
			// Check if the known term is on horizontal
			for (int i = 0; i < 3; i++) {
				if (!isUnknown[i][col]) {
					knownIndex = i;
					type = 1;
					break loops2;
				}
			}
			
			// If there are no terms in horizontal/vertical relationship, proceed to next unknown index
			col++;
			if (col == 3) {
				row++;
				col = 0;
			}
			
			loops3:
			for (int i = row; i < 3; i++) {
				for (int j = col; j < 3; j++) {
					if (isUnknown[i][j]) {
						row = i;
						col = j;
						break loops3;
					}
				}
			}
			
		}
		
		fillOneUnknown(numbers, isUnknown, type, row, col, knownIndex, factor);
		return true;
	}
	
	/* 
	 * Method to fills the unknown term with respect to its relative location of the known term 
	 * and the factor.
	 */
	public static void fillOneUnknown(int[][] numbers, boolean[][] isUnknown, int type, int row, int col, int knownIndex, int factor) {
		
		// Horizontal Fill - Unknown index is col
		if (type == 0) {
			if (knownIndex == 0) {
				if (col == 1) {
					numbers[row][col] = numbers[row][knownIndex] + factor;
				}
				if (col == 2) {
					numbers[row][col] = numbers[row][knownIndex] + factor * 2;
				}
			}
			
			if (knownIndex == 1) {
				if (col == 0) {
					numbers[row][col] = numbers[row][knownIndex] - factor;
				}
				if (col == 2) {
					numbers[row][col] = numbers[row][knownIndex] + factor;
				}
			}
			
			if (knownIndex == 2) {
				if (col == 0) {
					numbers[row][col] = numbers[row][knownIndex] - factor * 2;
				}
				if (col == 1) {
					numbers[row][col] = numbers[row][knownIndex] - factor;
				}
			}
		}
		
		// Vertical Fill - Unknown index is row
		if (type == 1) {
			if (knownIndex == 0) {
				if (row == 1) {
					numbers[row][col] = numbers[knownIndex][col] + factor;
				}
				if (row == 2) {
					numbers[row][col] = numbers[knownIndex][col] + factor * 2;
				}
			}
			
			if (knownIndex == 1) {
				if (row == 0) {
					numbers[row][col] = numbers[knownIndex][col] - factor;
				}
				if (row == 2) {
					numbers[row][col] = numbers[knownIndex][col] + factor;
				}
			}
			
			if (knownIndex == 2) {
				if (row == 0) {
					numbers[row][col] = numbers[knownIndex][col] - factor * 2;
				}
				if (row == 1) {
					numbers[row][col] = numbers[knownIndex][col] - factor;
				}
			}
		}
		
		isUnknown[row][col] = false;
	}
	
	
	// type 0 = horizontal, type 1 = vertical
	public static boolean checkOneUnknown(int[][] data, boolean[][] unknown, int index, int type) {
		int unknowns = 0; // Number of unknown terms in this row/col
		int unknownIndex = 0; // The index of the unknown term
		
		/*
		 * Checks how many unknown terms there are in this row/col, and find the unknown index if
		 * there is one unknown only.
		 */
		
		// Horizontal
		if (type == 0) {
			for (int i = 0; i < 3; i++) {
				if (unknown[index][i]) {
					unknowns++;
					unknownIndex = i;
				}
			}
		}
		
		// Vertical
		if (type == 1) {
			for (int i = 0; i < 3; i++) {
				if (unknown[i][index]) { 
					unknowns++;
					unknownIndex = i;
				}
			}
		}
		
		// If there is only one unknown term, solve based on their locations
		if (unknowns == 1) {
			int[] tempArr = new int[3];
			
			// Horizontal
			if (type == 0) {
				tempArr = solveOneUnknown(data[index][0], data[index][1], data[index][2], unknownIndex);
				unknown[index][0] = false;
				unknown[index][1] = false;
				unknown[index][2] = false;
				data[index][0] = tempArr[0];
				data[index][1] = tempArr[1];
				data[index][2] = tempArr[2];
			}
			
			// Vertical
			if (type == 1) {
				tempArr = solveOneUnknown(data[0][index], data[1][index], data[2][index], unknownIndex);
				unknown[0][index] = false;
				unknown[1][index] = false;
				unknown[2][index] = false;
				data[0][index] = tempArr[0];
				data[1][index] = tempArr[1];
				data[2][index] = tempArr[2];
			}
			return true;
		}
		
		// If it is all solved, or with more than one unknown
		return false;
	}
	
	// Method to solve one unknown with respect to two other known terms
	public static int[] solveOneUnknown(int n1, int n2, int n3, int unknown) {
		int[] result = {n1, n2, n3};
		
		if (unknown == 0) {
			result[0] = n2 - (n3 - n2);
		}
		
		if (unknown == 1) {
			result[1] = (n1 + n3) / 2;
		}
		
		if (unknown == 2) {
			result[2] = n2 + (n2 - n1);
		}
		return result;
	}
	
	// Method to check the square if solved (not necessarily correct)
	public static boolean checkCompletion(boolean[][] toCheck) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (toCheck[i][j]) { return false; };
			}
		}
		return true;
	}
		
	// Method to verify if everything is correct
	public static boolean verify(int[][] a) {
		if (a[0][2] - a[0][1] != a[0][1] - a[0][0]) { return false; }
		if (a[1][2] - a[1][1] != a[1][1] - a[1][0]) { return false; }
		if (a[2][2] - a[2][1] != a[2][1] - a[2][0]) { return false; }
		if (a[2][0] - a[1][0] != a[1][0] - a[0][0]) { return false; }
		if (a[2][1] - a[1][1] != a[1][1] - a[0][1]) { return false; }
		if (a[2][2] - a[1][2] != a[1][2] - a[0][2]) { return false; }
		return true;
	}
}
