package Questions_CCC;

import java.util.Scanner;

public class j2016_3 {
	public static void main(String [] args) {
		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();
		String tempCompare = "";
		int length = input.length();
		
		while (length > 1) {
			for (int i = 0; i < input.length() - length + 1; i++ ) {
				tempCompare = input.substring(i, i + length);
				if (tempCompare.equals(reverse(tempCompare))) {
					System.out.println(length);
					System.exit(0);
				}
			}
			length--;
		}
		
		reader.close();
	}
	
	public static String reverse(String thePhrase) {
		String output = "";
		
		for (int i = thePhrase.length() - 1; i >= 0; i--) {
			output += Character.toString(thePhrase.charAt(i));
		}
		
		return output;
	}
}
