package Questions_CCC;

import java.util.Scanner;

public class j2013_3 {
	public static void main(String [] args) {
		Scanner reader = new Scanner(System.in);
		int input = reader.nextInt();
		int[] n = new int[6];
		
		input++;
		while (true) {
			n[1] = input / 10000;
			n[2] = input % 10000 / 1000;
			n[3] = input % 1000 / 100;
			n[4] = input % 100 / 10;
			n[5] = input % 10;
			n = updateDigits(n);
			
			// 1 digit
			if (n[1] == 0 && n[2] == 0 && n[3] == 0 && n[4] == 0) {
				System.out.println(input);
				System.exit(0);
			}
			
			// 2 digits
			if (n[1] == 0 && n[2] == 0 && n[3] == 0) {
				if (n[4] != n[5]) {
					break;
				}
			}
			
			// 3 digits
			if (n[1] == 0 && n[2] == 0) {
				if (n[3] != n[4] && n[3] != n[5] && n[4] != n[5]) {
					break;
				}
			}
			
			// 4 digits
			if (n[1] == 0) {
				if (n[2] != n[3] && n[2] != n[4] && n[2] != n[5] && n[3] != n[4] && n[3] != n[5] && n[4] != n[5]) {
					break;
				}
			}
			
			// 5 digits
			if (n[1] != n[2] && n[1] != n[3] && n[1] != n[4] && n[1] != n[5] && n[2] != n[3] && n[2] != n[4] && n[2] != n[5] && n[3] != n[4] && n[3] != n[5] && n[4] != n[5]) {
				break;
			}
			
			input++;
		}
		System.out.println(input);
		reader.close();
	}	
	
	public static int[] updateDigits(int[] in) {
		if (in[5] >= 10) {
			in[5] -= 10;
			in[4]++;
		}
		
		if (in[4] >= 10) {
			in[4] -= 10;
			in[3]++;
		}
		
		if (in[3] >= 10) {
			in[3] -= 10;
			in[2]++;
		}
		
		if (in[2] >= 10) {
			in[2] -= 10;
			in[1]++;
		}
		
		if (in[1] >= 10) {
			in[1] -= 10;
			in[0]++;
		}
		return in;
	}
}
