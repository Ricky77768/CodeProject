package Questions_CCC;
import java.util.Scanner;

public class j2017_4_bruteforce {
	public static void main(String args[]) {
		Scanner reader = new Scanner(System.in);

		int total, d, t;
		total = 0;
		t = 0;
		d = reader.nextInt();

		// 12:34
		if (d >= 34) {
			total = total + 1;
			t = (d - 34) / 720;
			total = total + t;
		}
		// 1:11
		if (d >= 71) {
			total = total + 1;
			t = (d - 71) / 720;
			total = total + t;
		}
		// 1:23
		if (d >= 83) {
			total = total + 1;
			t = (d - 83) / 720;
			total = total + t;
		}
		// 1:35
		if (d >= 95) {
			total = total + 1;
			t = (d - 95) / 720;
			total = total + t;
		}
		// 1:47
		if (d >= 107) {
			total = total + 1;
			t = (d - 107) / 720;
			total = total + t;
		}
		// 1:59
		if (d >= 119) {
			total = total + 1;
			t = (d - 119) / 720;
			total = total + t;
		}
		// 2:10
		if (d >= 130) {
			total = total + 1;
			t = (d - 119) / 720;
			total = total + t;
		}
		// 2:22
		if (d >= 142) {
			total = total + 1;
			t = (d - 142) / 720;
			total = total + t;
		}
		// 2:34
		if (d >= 154) {
			total = total + 1;
			t = (d - 154) / 720;
			total = total + t;
		}
		// 2:46
		if (d >= 166) {
			total = total + 1;
			t = (d - 166) / 720;
			total = total + t;
		}
		// 2:58
		if (d >= 178) {
			total = total + 1;
			t = (d - 178) / 720;
			total = total + t;
		}
		// 3:21
		if (d >= 201) {
			total = total + 1;
			t = (d - 201) / 720;
			total = total + t;
		}
		// 3:33
		if (d >= 213) {
			total = total + 1;
			t = (d - 213) / 720;
			total = total + t;
		}
		// 3:45
		if (d >= 225) {
			total = total + 1;
			t = (d - 225) / 720;
			total = total + t;
		}
		// 3:57
		if (d >= 237) {
			total = total + 1;
			t = (d - 237) / 720;
			total = total + t;
		}
		// 4:20 blaze it
		if (d >= 260) {
			total = total + 1;
			t = (d - 260) / 720;
			total = total + t;
		}
		// 4:32
		if (d >= 272) {
			total = total + 1;
			t = (d - 272) / 720;
			total = total + t;
		}
		// 4:44
		if (d >= 284) {
			total = total + 1;
			t = (d - 284) / 720;
			total = total + t;
		}
		// 4:56
		if (d >= 296) {
			total = total + 1;
			t = (d - 296) / 720;
			total = total + t;
		}
		// 5:31
		if (d >= 331) {
			total = total + 1;
			t = (d - 331) / 720;
			total = total + t;
		}
		// 5:43
		if (d >= 343) {
			total = total + 1;
			t = (d - 343) / 720;
			total = total + t;
		}
		// 5:55
		if (d >= 355) {
			total = total + 1;
			t = (d - 355) / 720;
			total = total + t;
		}
		// 6:30
		if (d >= 390) {
			total = total + 1;
			t = (d - 390) / 720;
			total = total + t;
		}
		// 6:42
		if (d >= 402) {
			total = total + 1;
			t = (d - 402) / 720;
			total = total + t;
		}
		// 6:54
		if (d >= 414) {
			total = total + 1;
			t = (d - 414) / 720;
			total = total + t;
		}
		// 7:41
		if (d >= 461) {
			total = total + 1;
			t = (d - 461) / 720;
			total = total + t;
		}
		// 7:53
		if (d >= 473) {
			total = total + 1;
			t = (d - 473) / 720;
			total = total + t;
		}
		// 8:40
		if (d >= 520) {
			total = total + 1;
			t = (d - 520) / 720;
			total = total + t;
		}
		// 8:52
		if (d >= 532) {
			total = total + 1;
			t = (d - 532) / 720;
			total = total + t;
		}
		// 9:51
		if (d >= 591) {
			total = total + 1;
			t = (d - 591) / 720;
			total = total + t;
		}
		// 11:11
		if (d >= 671) {
			total = total + 1;
			t = (d - 671) / 720;
			total = total + t;
		}

		System.out.println(total);
		reader.close();
	}
}