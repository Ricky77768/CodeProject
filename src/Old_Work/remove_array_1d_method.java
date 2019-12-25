package Old_Work;
// Defines a method and uses it

// HW Finish sorting with two ways (temp int & swap)
public class remove_array_1d_method {
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

		int[] stock = { 1, 2, 3, 4, 5 };
		int[] finalstock = removearray(stock, 3);
		System.out.println("The new array is " + finalstock[0] + finalstock[1] + finalstock[2] + finalstock[3]);

	}
}
