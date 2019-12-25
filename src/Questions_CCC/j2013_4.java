package Questions_CCC;
import java.util.*;

public class j2013_4 {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int minutes = reader.nextInt();
		int numOfTasks = reader.nextInt();
		int[] tasks = new int[numOfTasks];
		
		for (int i = 0; i < tasks.length; i++) {
			tasks[i] = reader.nextInt();
		}
		
		tasks = sortArray(tasks);
		
		while (true) {
			for (int i = 0; i < tasks.length; i++) {
				minutes -= tasks[i];
				if (minutes < 0) {
					System.out.println(i);
					break;
				}		
				if (minutes == 0) {
					System.out.println(i + 1);
					break;
				}
			}
			break;
		}
		reader.close();
	}
	
	public static int[] sortArray(int[] input) {
		int temp;
		
		for (int i = 0; i < input.length; i++) {
			for (int i2 = 0; i2 < input.length - 1 - i; i2++) {
				if (input[i2] > input[i2 + 1]) {
					temp = input[i2];
					input[i2] = input[i2 + 1];
					input[i2 + 1] = temp;
					
				}
			}
		}
		return input;
	}
	
}
