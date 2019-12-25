package Old_Work;

public class swap_sort_array_1d {

	public static void main(String args[]) {
		int[] stock = { 56, 25, 9, 21, 2, 4 };
		int temp = 0;

		for (int count = 0; count < stock.length; count++) {
			for (int count2 = 0; count2 < stock.length - 1; count2++) {
				if (stock[count2] > stock[count2 + 1]) { // Switch Sign Here for B to S or S to B
					temp = stock[count2];
					stock[count2] = stock[count2 + 1];
					stock[count2 + 1] = temp;
				}
			}
		}

		System.out.println("The organized stock is: " + stock[0] + " " + stock[1] + " " + stock[2] + " " + stock[3]
				+ " " + stock[4] + " " + stock[5]);
	}
}
