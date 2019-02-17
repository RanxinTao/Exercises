package arrayReverse_derivative;

/**
 * Reverse the words in a sentence.
 *
 * Assumptions:
 * 1. Words are separated by single space.
 * 2. There are no heading or tailing white spaces.
 * 
 * Examples:
 * "I love Google" -> "Google love I"
 * 
 * Time: O(n)
 * Space: O(1), but O(n) in Java
 */
public class ReverseWordsInASentenceI {
	public String reverseWords(String input) {
		if (input == null) {
			return null;
		}
		char[] charArr = input.toCharArray();
		int first = 0; // indicates the index of the first character of the current word
		for (int i = 0; i < charArr.length; i++) {
			// find the index of the first character of the current word
			if (charArr[i] != ' ' && (i == 0 || charArr[i - 1] == ' ')) {
				first = i;
			}
			// find the index of the last character of the current word
			if (charArr[i] != ' ' && (i == charArr.length - 1 || charArr[i + 1] == ' ')) {
				reverse(charArr, first, i);
			}
		}
		// reverse the whole char array
		reverse(charArr, 0, charArr.length - 1);
		return new String(charArr);
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


