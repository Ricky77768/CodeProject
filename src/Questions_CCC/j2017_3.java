package Questions_CCC;
import java.util.Scanner;

public class j2017_3 {
	public static void main(String args[]) {
		Scanner reader = new Scanner(System.in);
		int startX = reader.nextInt();
		int startY = reader.nextInt();
		int endX = reader.nextInt();
		int endY = reader.nextInt();
		int charges = reader.nextInt();
		int required = Math.abs(endX - startX) + Math.abs(endY - startY);

		if (required <= charges && required % 2 == charges % 2) {
			System.out.println("Y");
		}
		else {
			System.out.println("N");
		}
		reader.close();
	}
}