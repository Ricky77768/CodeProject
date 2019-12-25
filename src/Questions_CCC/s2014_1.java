package Questions_CCC;
import java.util.*;

public class s2014_1 {
	public static void main (String[] args) {
		Scanner reader = new Scanner(System.in);
		int[] friends = new int[reader.nextInt()];
		int[] rounds = new int[reader.nextInt()];
		
		for (int i = 0; i < rounds.length; i++) {
			rounds[i] = reader.nextInt();
		}
		
		for (int i = 0; i < friends.length; i++) {
			friends[i] = i;
		}
		
		for (int i = 0; i < rounds.length; i++) {
			for (int i2 = 0; i2 < friends.length; i2++) {
				if (i2 % rounds[i] == rounds[i] - 1) {
					friends[i2] = -1;
				}
			}
			friends = removeNegatives(friends);
		}
		
		for (int i = 0; i < friends.length; i++) {
			System.out.println(friends[i] + 1);
		}
		
		reader.close();
	}
	
	public static int[] removeNegatives(int[] old) {
		int count = 0; // Number of negative ints
		int offset = 0; // Used to fit array elements after finding -1s
		
		for (int i = 0; i < old.length; i++) {
			if (old[i] == -1) {
				count++;
			}
		}
		int[] newArr = new int[old.length - count];
		
		for (int i = 0; i < old.length; i++) {
			if (old[i] == -1) {
				offset++;
			}
			else {
				newArr[i - offset] = old[i];
			}
		}	
		return newArr;
	}
}
