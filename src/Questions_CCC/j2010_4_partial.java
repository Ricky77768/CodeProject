package Questions_CCC;

import java.util.Scanner;

/**
 * Only works if there are two complete patterns (Special cases also does not work)
 */
public class j2010_4_partial {
	public static void main(String [] args) {
		Scanner reader = new Scanner(System.in);
		int input;
		int cycle = 1;
		boolean isCycle = true;
		input = reader.nextInt();
		
		while (input != 0) {
			
			int[] numbers = new int[input];
			for (int i = 0; i < input; i++) {
				numbers[i] = reader.nextInt();
 			}
		
			int[] diff = new int[numbers.length - 1];
			for (int i = 0; i < diff.length; i++) {
				diff[i] = numbers[i + 1] - numbers[i];
			}
			
			//printArray(numbers);
			//printArray(diff);
			
			while (true) {
				for (int i = 0; i < diff.length; i += cycle) {
					int[] split1 = new int[cycle];
					int[] split2 = new int[cycle];
					
					try {
						split1[i] = diff[i];
						split2[i] = diff[i + cycle];
					}
					catch (Exception e) {
						
					}
					
					for (int i2 = 0; i2 < split1.length; i2++) {
						if (split1[i2] != split2[i2]) {
							isCycle = false;
							break;
						}
					}
					
					//printArray(diff);
					//printArray(split1);
					//printArray(split2);
				}
				
				if (isCycle == false) {
					cycle++;
					isCycle = true;
				}
				else {
					break;
				}
				
				if (cycle > diff.length / 2) {
					break;
				}
			}
			System.out.println(cycle);
			
			// Reset variables
			for (int i = 0; i < numbers.length; i++) {
				numbers[i] = 0;
 			}
			cycle = 1;
			input = reader.nextInt();
		}
		reader.close();
	}
	
	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
