package arrayReverse_derivative;

/**
 * Reverse the words in a sentence and truncate all heading/trailing/duplicate space characters.
 * 
 * Examples: 
 * " I  love  Google  " ¡ú "Google love I"
 */
public class ReverseWordsInASentenceII {
	public String reverseWords(String input) {
		char[] array = input.toCharArray();
		int end = 0;
		int first = 0;
		// reverse each of the words.
		for (int i = 0; i < array.length; i++) {
			if (array[i] == ' ') {
				if (i != 0 && array[i - 1] != ' ') {
					array[end] = array[i];
					end++;
				}
			} else { // array[i] != ' '
				// the first index of a word
				if (i == 0 || array[i - 1] == ' ') {
					first = i;
				}
				// the last index of a word
				if (i == array.length - 1 || array[i + 1] == ' ') {
					reverse(array, first, i);
					while (first <= i) {
						array[end] = array[first];
						first++;
						end++;
					}
				}
			}
		}
		// post-processing
		if (end > 0 && array[end - 1] == ' ') {
			end--;
		}
		// reverse the whole char array
		reverse(array, 0, end - 1);
		return new String(array, 0, end);
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
	
	/*public String reverseWords(String input) {
		if (input == null) {
			return null;
		}
		int start = 0;
		while (start < input.length() && input.charAt(start) == ' ') {
			start++;
		}
		int end = input.length() - 1;
		while (end >= 0 && input.charAt(end) == ' ') {
			end--;
		}
		// calculate the length of the char array
		int chars = 0;
		int spaces = 0;
		for (int i = start; i <= end; i++) {
			if (input.charAt(i) != ' ') {
				chars++;
			} else {
				spaces++;
				// skip the rest spaces
				while (i + 1 < input.length() && input.charAt(i + 1) == ' ') {
					i++;
				}
			}
		}
		
		// fill the char array
		int len = chars + spaces;
		char[] array = new char[len];
		for (int i = 0; i < len; i++) {
			char cur = input.charAt(start);
			if (cur != ' ') {
				array[i] = cur;
				start++;
			} else {
				array[i] = ' ';
				while (start < input.length() && input.charAt(start) == ' ') {
					start++;
				}
			}
		}
		// operate on char array
		start = 0;
	    for (int i = start + 1; i < array.length; i++) {
	      if (array[i] == ' ') {
	        reverse(array, start, i - 1);
	        start = i + 1;
	        i = start;
	      }
	    }
	    //reverse the last word
	    reverse(array, start, array.length - 1); 
	    //reverse the whole sentence
	    reverse(array, 0, array.length - 1);
	    return new String(array);
	}*/
	
	public static void main(String[] args) {
		ReverseWordsInASentenceII test = new ReverseWordsInASentenceII();
		String input = " I  love  Google  ";
		//String input = "IQ";
		//String input = "              ";
		System.out.println(test.reverseWords(input));
	}
}
