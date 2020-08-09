package array2Pointers_oppositeDirection;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 * 
 * Examples:
 * 1. 69 is strobogrammatic.
 * 2. 88 is strobogrammatic.
 * 3. 818 is strobogrammatic.
 * 
 * Thoughts: We only need to pay attention to 0, 1, 8, 6, and 9.
 * 
 * Time: O(n), where n is the length of the input string
 * Space: O(1)
 */
public class StrobogrammaticNumber {
	public boolean isStrobogrammatic(String num) {
		int l = 0;
		int r = num.length() - 1;
		while (l <= r) {
			char c1 = num.charAt(l);
			char c2 = num.charAt(r);
			if ((c1 == '0' && c2 == '0') || (c1 == '1' && c2 == '1') || (c1 == '8' && c2 == '8') || (c1 == '6' && c2 == '9') || (c1 == '9' && c2 == '6')) { // don't forget ''
				l++;
				r--;
			} else {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		StrobogrammaticNumber test = new StrobogrammaticNumber();
		String num = "25";
		System.out.println(test.isStrobogrammatic(num));
	}
}
