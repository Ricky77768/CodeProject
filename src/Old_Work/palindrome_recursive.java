package Old_Work;

public class palindrome_recursive {
	public static void main (String[] args) {
		
		String test = "evacanistabbatsinecave";	
		System.out.println(isPalindrome(test, 0, test.length() - 1));
	
	}
	
	public static boolean isPalindrome(String s, int start, int end) {
		if (s.length() == 0 || s.length() == 1) {
			return true;
		}
		else if (s.substring(0, 1).equals(s.substring(s.length() - 1))) {
			String s2 = s.substring(1, s.length() - 1);
			return isPalindrome(s2, 0, s2.length() - 1);
		}
		else {
			return false;
		}
	}
	
}
