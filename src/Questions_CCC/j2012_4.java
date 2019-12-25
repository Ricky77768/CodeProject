package Questions_CCC;

import java.util.Scanner;

public class j2012_4 {
	public static void main(String [] args) {
		Scanner reader = new Scanner(System.in);
		int k = reader.nextInt();
		reader.nextLine();
		String input = reader.nextLine();
		
		// 65 - 90, 3P + K
		char[] oldMsg = new char[input.length()];
		int[] newMsg = new int[input.length()];
		
		for (int i = 0; i < oldMsg.length; i++) {
			oldMsg[i] = input.charAt(i);
		}
		
		for (int i = 0; i < newMsg.length; i++) {
			newMsg[i] = oldMsg[i] - (3 * (i + 1)) - k;
			if (newMsg[i] < 65) {
				newMsg[i] += 26;
			}
		}
		
		for (int i : newMsg) {
			System.out.print(Character.toChars(i));
		}
		reader.close();
	}
}
