package array2Pointers_sameDirection;

/**
 * Assumptions: input is not null
 */
public class RemoveSpaces {
	public String removeSpaces(String input) {
		if (input.length() == 0) {
			return input;
		}
		char[] charArr = input.toCharArray();
		int end = 0; // the left to end (exclusive) is to be kept
		for (int i = 0; i < charArr.length; i++) {
			if (charArr[i] == ' ' && (i == 0 || charArr[i - 1] == ' ')) {
				continue;
			}
			charArr[end] = charArr[i];
			end++;
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
