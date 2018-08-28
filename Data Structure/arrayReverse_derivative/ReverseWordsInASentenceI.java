package arrayReverse_derivative;

/**
 * Assumptions: 
 * 1. Words are separated by single space.
 * 2. There are no heading or tailing white spaces.
 * Examples:
 * "I love Google" ¡ú "Google love I"
 */
public class ReverseWordsInASentenceI {
	public String reverseWords(String input) {
		if (input == null) {
			return null;
		}
		char[] array = input.toCharArray();
		int first = 0;
		for (int i = first + 1; i < array.length; i++) {
			if (array[i] == ' ') {
				reverse(array, first, i - 1);
				first = i + 1;
				i = first;
			}
		}
		// reverse the last word
		reverse(array, first, array.length - 1);
		// reverse the whole char array
		reverse(array, 0, array.length - 1);
		return new String(array);
	}
	
	private void reverse(char[] array, int left, int right) {
		while (left < right) {
			char tmp = array[left];
			array[left] = array[right];
			array[right] = tmp;
			left++;
			right--;
		}
	}
	
	public static void main(String[] args) {
		ReverseWordsInASentenceI test = new ReverseWordsInASentenceI();
		String input = "I love Google";
		System.out.println(test.reverseWords(input));
	}
}


