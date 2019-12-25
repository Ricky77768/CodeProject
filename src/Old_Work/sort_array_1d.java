package Old_Work;

public class sort_array_1d {

	public static int[] removearray(int[] stock, int number) {
		int[] newstock = new int[stock.length - 1];
		// count: index of old array
		for (int count = 0; count < stock.length; count++) {
			if (count < number) {
				newstock[count] = stock[count];
			} else if (count > number) {
				newstock[count - 1] = stock[count];
			}
		}
		return newstock;
	}

	public static void main(String args[]) {

		int temp;
		int[] stock = { 3, 1, 5, 2, 4 };
		int[] sortstock = new int[5];

		for (int count = 0; count < sortstock.length; count++) {
			temp = 0;
			for (int count2 = 0; count2 < stock.length; count2++) {
				if (stock[count2] >= stock[temp]) {
					temp = count2;
				}
			}
			sortstock[count] = stock[temp];
			stock = removearray(stock, temp);

		}
		System.out.println("The sorted stock is: " + sortstock[0] + " " + sortstock[1] + " " + sortstock[2] + " "
				+ sortstock[3] + " " + sortstock[4]);

	}
}
