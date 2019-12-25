package Questions_CCC;
import java.util.Scanner;

public class j2015_2 {
	public static void main(String[] args) {

		int happy = 0, sad = 0;
		Scanner reader = new Scanner(System.in);

		String input = reader.nextLine();
		char[] list = new char[input.length()];

		for (int count = 0; count < input.length(); count++) {
			list[count] = input.charAt(count);
		}

		for (int count2 = 0; count2 < input.length(); count2++) {
			if (list[count2] == ':' && list[count2 + 1] == '-') {
				if (list[count2 + 2] == '(') {
					sad = sad + 1;
				}
				if (list[count2 + 2] == ')') {
					happy = happy + 1;
				}
			}
		}

		if (happy == 0 && sad == 0) {
			System.out.println("none");
		}
		if (happy != 0 && sad != 0) {
			if (happy == sad) {
				System.out.println("unsure");
			}
		}
		if (happy > sad) {
			System.out.println("happy");
		}
		if (sad > happy) {
			System.out.println("sad");
		}
		reader.close();
	}
}
