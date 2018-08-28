package array2Pointers_sameDirection;

/**
 * duplicate element only retain one
 * "aaaabbbc" ¡ú "abc"
 */
public class RemoveAdjacentRepeatedCharactersI {
	public String deDup(String input) {
		if (input == null || input.length() <= 1) {
			return input;
		}
		char[] array = input.toCharArray();
		int end = 0; 
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
