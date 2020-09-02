package array2Pointers_moveTowards;

/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a
 * palindrome.
 * 
 * Assumptions:
 * 1. The string will only contain lowercase character a-z.
 * 2. The maximum length of the string is 50000.
 * 
 * Examples:
 * 1. Input: "aba"	Output: True
 * 2. Input: "abca"	Output: True	Explanation: You could delete the character 'c'.
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class ValidPalindromeII {
	public boolean validPalindrome(String input) {
		for (int l = 0, r = input.length() - 1; l < r;) {
			if (input.charAt(l) == input.charAt(r)) {
				l++;
				r--;
			} else if (validPal(input, l + 1, r) || validPal(input, l, r - 1)) { // still have a chance to delete the left or the right char
				return true;
			} else { // input.charAt(l) != input.charAt(r) and deleting a char still doesn't make it a palindrome
				return false;
			}
		}
		return true;
	}
		
	private boolean validPal(String input, int l, int r) {
		while (l < r) {
			if (input.charAt(l++) != input.charAt(r--)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		ValidPalindromeII test = new ValidPalindromeII();
		String input = "abca";
		System.out.println(test.validPalindrome(input));
	}
}
