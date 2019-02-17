package array2Pointers_sameDirection;

/**
 * Given a string, remove all leading/trailing/duplicated empty spaces.
 *
 * Assumptions:
 * The given string is not null
 * 
 * Examples:
 * 1. " a" --> "a"
 * 2. "  I   love MTV " --> "I love MTV"
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class RemoveSpaces {
	public String removeSpaces(String input) {
		char[] charArr = input.toCharArray();
		int end = 0; // the left to end (exclusive) is to be kept
		for (int i = 0; i < charArr.length; i++) {
			if (charArr[i] != ' ' || (i - 1 >= 0 && charArr[i - 1] != ' ')) {
				charArr[end] = charArr[i];
				end++;
			}
		}
		if (end > 0 && charArr[end - 1] == ' ') {
			end--;
		}
		return new String(charArr, 0, end);
	}
	
	public static void main(String[] args) {
		RemoveSpaces test = new RemoveSpaces();
		String input = "   I     love MTV ";
		System.out.println(test.removeSpaces(input));
	}
}
