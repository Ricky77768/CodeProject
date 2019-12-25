package Questions_CCC;
import java.util.*;

public class j2007_4 {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		String firstPhrase = reader.nextLine();
		String secondPhrase = reader.nextLine();
		firstPhrase = firstPhrase.replaceAll("\\s", "");
		secondPhrase = secondPhrase.replaceAll("\\s", "");
		
		if (firstPhrase.length() != secondPhrase.length()) {
			System.out.println("This is no anagram xd");
			System.exit(0);
		}
		
		char[] first = new char[firstPhrase.length()];
		char[] second = new char[secondPhrase.length()];
		int progress = 0;
		char charToCompare;
		
		for (int i = 0; i < firstPhrase.length(); i++) {
			first[i] = firstPhrase.charAt(i);
		}
		
		for (int i = 0; i < secondPhrase.length(); i++) {
			second[i] = secondPhrase.charAt(i);
		}
		
		// First Phrase - Change into alphabetical order
		while (progress < firstPhrase.length() - 1) {
			charToCompare = first[progress];
			
			for (int i = 0; i < firstPhrase.length() - progress; i++) {
				if (charToCompare > first[i + progress]) {
					first[progress] = first[i + progress];
					first[i + progress] = charToCompare;
					charToCompare = first[progress];
				}
			}
			progress++;
		}
		
		// Second Phrase - Change into alphabetical order
		progress = 0;
		while (progress < secondPhrase.length() - 1) {
			charToCompare = second[progress];
			
			for (int i = 0; i < secondPhrase.length() - progress; i++) {
				if (charToCompare > second[i + progress]) {
					second[progress] = second[i + progress];
					second[i + progress] = charToCompare;
					charToCompare = second[progress];
				}
			}
			progress++;
		}
		
		for (int i = 0; i < first.length; i++) {
			if (first[i] != second[i]) {
				System.out.println("This is no anagram xd");
				System.exit(0);
			}
		}
		
		System.out.println("This is an anagram YEET");
		reader.close();
	}
}
