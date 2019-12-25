package Questions_CCC;
import java.util.*;

public class j2017_4 {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int timePassed = reader.nextInt();
		int timeLeft;
		int total = 0;
		int[] time = {1, 2, 0, 0}; // [0] & [1] Hours, [2] & [3] Minutes
		
		// To save compile time if time is longer than 0.5 day
		if (timePassed > 720) {
			timeLeft = timePassed % 720;
			total += 31 * ((timePassed - timeLeft) / 720);
		}
		else {
			timeLeft = timePassed;
		}
		
		// Check the remaining <0.5 day
		while (timeLeft > 0) {
			
			// Update Current Time
			time[3]++;
			time = timeUpdate(time);
			
			// Check if current time is a arithmetic sequence
			if (time[0] == 0) {
				if (time[3] - time[2] == time[2] - time[1]) {
					total++;
				}
			}
			else {
				if (time[3] - time[2] == time[2] - time[1] && time[2] - time[1] == time[1] - time[0]) {
					total++;
				}
			}
			timeLeft--;
		}
		System.out.println(total);
		reader.close();
	}
	
	public static int[] timeUpdate(int[] input) {
		
		// 00:09 -> 00:10
		if (input[3] > 9) {
			input[2]++;
			input[3] -= 10;
		}
		
		// 00:59 -> 01:00
		if (input[2] > 5) {
			input[1]++;
			input[2] -= 6;
		}
		
		// 09:59 -> 10:00
		if (input[0] == 0) {
			if (input[1] > 9) {
				input[0]++;
				input[1] -= 10;
			}
		}
		
		// 12:59 -> 1:00
		if (input[0] == 1) {
			if (input[1] > 2) {
				input[0] = 0;
				input[1] = 1;
			}
		}
		return input;
	}
	
}
