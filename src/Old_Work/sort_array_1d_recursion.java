package Old_Work;

import java.util.Arrays;

public class sort_array_1d_recursion {

	/*
	 * Input: An 1D array of integers in random order
	 * 
	 * Function: It will use recursion to select the last element from the 1D array until the length is 1.
	 * Then, it will return the array and the element previously picked out will be inserted in the
	 * right place using the insertion method. This continues until recursion is complete.
	 * 
	 * Output: A sorted 1D array
	 */
	public static int[] sort_1d(int[] list) {
		if (list.length == 1) {
			return list;
		}
		else {
			return insert_sorted(list[list.length - 1], sort_1d(Arrays.copyOfRange(list, 0, list.length - 1)));
		}
	}
	
	
		
		/* Insertion method
		 * Input: One integer and one sorted 1D array of integers in ascending order
		 * 
		 * Function: Inserts the input integer into the right place
		 * 
		 * Output: a new 1D array that is one element longer than the input array
		 */
	
		public static int[] insert_sorted(int number, int[] list) {
			
		int[] final_list = new int[list.length + 1];
		int insert_index = 0;

		// Acquires the index that the number should be inserted in
		for (int i = 0; i < list.length; i++) {
			if (list[i] > number || list[i] == number) {
				break;
			}
			insert_index++;
		}

		// Copies the elements from the old array, and insert the number according to
		// the index
		for (int i = 0; i < final_list.length; i++) {
			if (i < insert_index) {
				final_list[i] = list[i];
			} else if (i == insert_index) {
				final_list[i] = number;
			} else {
				final_list[i] = list[i - 1];
			}
		}
		return final_list;
	} 

	public static void main(String[] args) {
		int[] array = { 7, 1, 8, 2 };
		int[] final_array = sort_1d(array);

		// Prints out array
		for (int i = 0; i < final_array.length; i++) {
			System.out.print(final_array[i] + " ");
		}
	}
}
