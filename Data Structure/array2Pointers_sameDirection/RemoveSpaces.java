package array2Pointers_sameDirection;

/**
 * Assumptions: input is not null
 */
public class RemoveSpaces {
	public String removeSpaces(String input) {
		if (input.length() == 0) {
			return input;
		}
		char[] array = input.toCharArray();
		int len = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == ' ' && (i == 0 || array[i - 1] == ' ')) {
				continue;
			}
			array[len] = array[i];
			len++;
		}
		if (len > 0 && array[len - 1] == ' ') {
			len--;
		}
		return new String(array, 0, len);
	}
	
	public static void main(String[] args) {
		RemoveSpaces test = new RemoveSpaces();
		String input = "   I     love MTV ";
		System.out.println(test.removeSpaces(input));
	}
}
