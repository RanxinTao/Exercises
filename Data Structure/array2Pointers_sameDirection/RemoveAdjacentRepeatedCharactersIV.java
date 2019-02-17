package array2Pointers_sameDirection;

/**
 * Repeatedly remove all adjacent, repeated characters in a given string from left to right. No adjacent characters
 * should be identified in the final string.
 * (duplicate element not retain any, repeatedly deduplication)
 * 
 * Examples:
 * 1. "abbbaaccz" -> "aaaccz" -> "ccz" -> "z"
 * 2. "aabccdc" -> "bccdc" -> "bdc"
 * 
 * Time: O(n)
 * Space: O(1), but O(n) in java
 */
public class RemoveAdjacentRepeatedCharactersIV {
	public String deDup(String input) {
		if (input == null || input.length() <= 1) {
			return input;
		}
		char[] array = input.toCharArray();
		int top = 0; // indicates the top of the stack
		for (int i = 1; i < array.length; i++) {
			if (top == -1 || array[top] != array[i]) {
				top++;
				array[top] = array[i];
			} else {
				while (i + 1 < array.length && array[i + 1] == array[top]) {
					i++;
				}
				top--;
			}
		}
		return new String(array, 0, top + 1);
	}

	public static void main(String[] args) {
		RemoveAdjacentRepeatedCharactersIV test = new RemoveAdjacentRepeatedCharactersIV();
		String input = "aabccdc";
		System.out.println(test.deDup(input));
	}
}
