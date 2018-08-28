package array2Pointers_sameDirection;

/**
 * duplicate element not retain any, repeatedly deduplication
 * "abbbaaccz" ¡ú "aaaccz" ¡ú "ccz" ¡ú "z"
 * "aabccdc" ¡ú "bccdc" ¡ú "bdc"
 */
public class RemoveAdjacentRepeatedCharactersIV {
	public String deDup(String input) {
		if (input == null || input.length() <= 1) {
			return input;
		}
		char[] array = input.toCharArray();
		int top = 0;
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
