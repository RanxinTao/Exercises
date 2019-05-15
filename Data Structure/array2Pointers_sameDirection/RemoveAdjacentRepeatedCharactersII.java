package array2Pointers_sameDirection;

/**
 * Remove adjacent, repeated characters in a given string, leaving only two characters for each group of 
 * such characters. The characters in the string are sorted in ascending order.
 *
 * Assumptions:
 * Try to do it in place.
 * 
 * Examples:
 * ¡°aaaabbbc¡± is transferred to ¡°aabbc¡±
 */
public class RemoveAdjacentRepeatedCharactersII {
	public String deDup(String input) {
		if (input == null || input.length() <= 2) {
			return input;
		}
		char[] charArray = input.toCharArray();
		// elements start from 0 and array[end] (inclusive) are kept.
		int end = 1;
		for (int i = 2; i < charArray.length; i++) {
			if (charArray[end - 1] != charArray[i]) {
				end++;
				charArray[end] = charArray[i];
			}
		}
		return new String(charArray, 0, end + 1);
	}
	
	public static void main(String[] args) {
		RemoveAdjacentRepeatedCharactersII test = new RemoveAdjacentRepeatedCharactersII();
		String input = "aaaabbbc";
		System.out.println(test.deDup(input));
	}
}
