package Questions_CCC;
import java.util.*;

public class j2016_4 {
	public static void main (String[] args) {
		Scanner reader = new Scanner(System.in);		
		String hourAndMinute = reader.nextLine();
		char[] input = new char[hourAndMinute.length()];
		int[] HM = new int[2]; // 0 Hour, 1 Minute
		
		for (int i = 0; i < hourAndMinute.length(); i++) {
			input[i] = hourAndMinute.charAt(i);
		}	
		
		int timeLeft = 120;
		HM[0] = Character.getNumericValue(input[0]) * 10 + Character.getNumericValue(input[1]);
		HM[1] = Character.getNumericValue(input[3]) * 10 + Character.getNumericValue(input[4]);
		
		// 7:00 - 10:00 & 15:00 - 19:00
		while (timeLeft != 0) {
			
			if ((HM[0] > 6 && HM[0] < 10) || (HM[0] > 14 && HM[0] < 19)) {
				timeLeft--;	
				HM[1] += 3;
				HM = valueChange(HM);

			}
						
			timeLeft--;	
			HM[1]++;
			HM = valueChange(HM);
		}
		
		if (HM[0] < 10) {
			System.out.print("0");
		}
		System.out.print(HM[0] + ":");
		
		if (HM[1] < 10) {
			System.out.print("0");
		}
		
		System.out.println(HM[1]);
		reader.close();
	}
	
	public static int[] valueChange(int[] input) {
		if (input[1] >= 60) {
			input[0]++;
			input[1] -= 60;
		}
		
		if (input[0] == 24) {
			input[0] = 0;
		}
		
		return input;
	}
}


