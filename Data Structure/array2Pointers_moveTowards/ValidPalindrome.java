package array2Pointers_moveTowards;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric character ('0'-'9',
 * 'a'-'z', 'A'-'Z') and ignoring cases.

 * Examples:
 * 1. "an apple, :) elp pana#" is a palindrome.
 * 2. "dia monds dn dia" is not a palindrome.
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class ValidPalindrome {
	public boolean valid(String input) {
		for (int l = 0, r = input.length() - 1; l < r;) {
			char lCh = input.charAt(l);
			if (!isLetter(lCh) && !isDigit(lCh)) {
				l++;
				continue;
			}
			char rCh = input.charAt(r);
			if (!isLetter(rCh) && !isDigit(rCh)) {
				r--;
				continue;
			}
			if (Character.toLowerCase(lCh) != Character.toLowerCase(rCh)) {
				return false;
			}
			l++;
			r--;		
		}
		return true;
	}
	
	private boolean isLetter(char ch) {
		return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
	}
	
	private boolean isDigit(char ch) {
		return ch >= '0' && ch <= '9';
	}
	
	public static void main(String[] args) {
		ValidPalindrome test = new ValidPalindrome();
		//String input = "an apple, :) elp pana#"; // true
		String input = "dia monds dn dia"; // false
		System.out.println(test.valid(input));
	}
}
