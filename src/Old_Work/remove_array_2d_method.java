package Old_Work;

import java.util.Arrays;

public class remove_array_2d_method {
	// count: index of old array
	public static int[][] removearray2d(int[][] itemlist, int number, int number2) {
		int[][] newlist = new int[itemlist.length][itemlist[0].length];

		for (int count = 0; count < itemlist.length; count++) {
			if (count == number) {
				for (int count2 = 0; count2 < itemlist[0].length; count2++) {
					if (count2 < number2) {
						newlist[number][count2] = itemlist[number][count2];
					} else if (count2 > number2) {
						newlist[number][count2 - 1] = itemlist[number][count2];
					}
				}
			} else {
				for (int count2 = 0; count2 < itemlist[0].length; count2++) {
					newlist[count][count2] = itemlist[count][count2];
				}
			}
		}
		return newlist;
	}

	public static void main(String args[]) {
		int[][] itemlist = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 } };

		int finalitem[][] = removearray2d(itemlist, 2, 2);
		System.out.println(Arrays.toString(finalitem));
	}
}