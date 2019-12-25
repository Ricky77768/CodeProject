package Questions_CCC;

import java.util.ArrayList;
import java.util.Scanner;

public class j2014_5 {
	public static void main(String [] args) {
		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();
		ArrayList<String> s1 = new ArrayList<String>();
		ArrayList<String> s2 = new ArrayList<String>();
		int tempIndex;
		String temp, temp2, temp3, temp4;
		
		for (int i = 0; i < n; i++) {
			s1.add(reader.next());
		}
		
		for (int i = 0; i < n; i++) {
			s2.add(reader.next());
		}
		
		// If odd number of people (impossible)
		if (n % 2 == 1) {
			System.out.println("bad");
			System.exit(0);
		}
		
		// If partnered with themselves
		for (int i = 0; i < n; i++) {
			if (s1.get(i).equals(s2.get(i))) {
				System.out.println("bad");
				System.exit(0);
			}
		}
		
		while (s1.size() != 0) {
			temp = s1.get(0);
			temp2 = s2.get(0);
			tempIndex = s2.indexOf(temp);
			
			// Special - No Other Partners
			if (tempIndex == -1) {
				System.out.println("bad");
				System.exit(0);
			}
			
			temp3 = s1.get(tempIndex);
			temp4 = s2.get(tempIndex);
			
			// System.out.println(temp + " " + temp2 + " " + temp3 + " " + temp4);
			
			if (temp.equals(temp4) && temp2.equals(temp3)) {
				s1.remove(0);
				s2.remove(0);
				s1.remove(tempIndex - 1);
				s2.remove(tempIndex - 1);
			}
			else {
				System.out.println("bad");
				System.exit(0);
			}
 		}
		
		System.out.println("good");
		reader.close();
	}
}
