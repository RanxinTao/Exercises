package array2Pointers_sameDirection;

/**
 * Remove adjacent, repeated characters in a given string, leaving no character for each group of 
 * such characters. The characters in the string are sorted in ascending order.
 *
 * Assumptions:
 * Try to do it in place.
 * 
 * Examples:
 * ¡°aaaabbbc¡± is transferred to ¡°c¡±
 */
public class RemoveAdjacentRepeatedCharactersIII {
	public String deDup(String input) {
		if (input == null || input.length() <= 1) {
			return input;
		}
		char[] charArray = input.toCharArray();
		// elements start from 0 and array[end] (exclusive) are kept.
		int end = 0;
		boolean repeated = false;
		for (int i = 1; i < charArray.length; i++) {
			if (charArray[i] == charArray[end]) {
				repeated = true;
			} else if (!repeated) {
				end++;
				charArray[end] = charArray[i];
			} else {
				charArray[end] = charArray[i];
				repeated = false;
			}
		}
		return new String(charArray, 0, repeated ? end : end + 1);
	}
}
