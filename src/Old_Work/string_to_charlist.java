package Old_Work;

import java.util.Arrays;

public class string_to_charlist {

	public static void main(String[] args) {

		String x = "89dfghdxr";
		char[] output = new char[x.length()];

		for (int count = 0; count < x.length(); count++) {
			output[count] = x.charAt(count);
			System.out.println(Arrays.toString(output));
		}
	}
}
