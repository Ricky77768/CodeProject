package Questions_CCC;
import java.util.*;

public class s2019_2 {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		// Read input
		int length = reader.nextInt();
		int[] numbers = new int[length];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = reader.nextInt();
		}
		
		// Getting a list of prime numbers
		int factor = 2;
		int multiplier = 2;
		boolean[] primeNumbers = new boolean[2000000]; // true is NOT prime, false IS prime
		
		while (factor < primeNumbers.length / 2) {
			while (factor * multiplier < primeNumbers.length) {
				primeNumbers[factor * multiplier] = true;
				multiplier++;
			}
			multiplier = 2;
			factor++;
		}
		
		// Computing Results
		for (int i = 0; i < numbers.length; i++) {
			int current = numbers[i];
			int target = 2 * current;
			
			while (primeNumbers[current] == false) {
				current--;
			}
			
			// Start from middle of the target number, repeat in prime number list until match is found 
			// from one prime number
			int other = target - current;
			
			while (primeNumbers[current] || primeNumbers[other]) {
				current--;
				other = target - current;
			}
			System.out.println(current + " " + other);
		}
		reader.close();
	}
}
