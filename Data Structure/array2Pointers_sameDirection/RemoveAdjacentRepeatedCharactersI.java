package array2Pointers_sameDirection;

/**
 * Remove adjacent, repeated characters in a given string, leaving only one character for each group of such characters.
 * (duplicate element only retain one) Try to do it in place.
 * 
 * Examples:
 * "aaaabbbc" is transferred to "abc"
 * 
 * Time: O(n)
 * Space: O(1), but O(n) in java
 */
public class RemoveAdjacentRepeatedCharactersI {
	public String deDup(String input) {
		if (input == null || input.length() <= 1) {
			return input;
		}
		char[] array = input.toCharArray();
		int end = 0; // the left to end (inclusive) is to be kept 
		for (int i = 1; i < array.length; i++) {
			if (array[end] != array[i]) {
				end++;
				array[end] = array[i];
			}
		}
		return new String(array, 0, end + 1);
	}

	public static void main(String[] args) {
		RemoveAdjacentRepeatedCharactersI test = new RemoveAdjacentRepeatedCharactersI();
		String input = "aaaabbbc";
		System.out.println(test.deDup(input));
	}
}
