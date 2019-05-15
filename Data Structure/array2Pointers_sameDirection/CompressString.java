package array2Pointers_sameDirection;

/**
 * Given a string, replace adjacent, repeated characters with the character followed by the number of repeated occurrences. 
 * If the character does not has any adjacent, repeated occurrences, it is not changed.
 *
 * Assumptions:
 * The string is not null
 * The characters used in the original string are guaranteed to be ¡®a¡¯ - ¡®z¡¯
 * There are no adjacent repeated characters with length > 9
 * 
 * Examples:
 * ¡°abbcccdeee¡± ¡ú ¡°ab2c3de3¡±
 */
public class CompressString {
	public String compress(String input) {
		if (input.length() == 0) {
			return input;
		}
		char[] charArray = input.toCharArray();
		int end = 0;
		int count = 1;
		for (int i = 1; i < input.length(); i++) {
			if (charArray[end] == charArray[i]) {
				count++;
			} else {
				end++;
				if (count > 1) {
					charArray[end] = (char) (count + '0');
					end++;
				}
				charArray[end] = charArray[i];
				count = 1;
			}
		}
		if (count > 1) {
			end++;
			charArray[end] = (char) (count + '0');
		}
		return new String(charArray, 0, end + 1);
	}
	
	/*public String compress(String input) {
		if (input.length() == 0) {
			return input;
		}
		StringBuilder sb = new StringBuilder();
		char last = input.charAt(0);
		int count = 1;
		for (int i = 1; i < input.length(); i++) {
			if (input.charAt(i) == last) {
				count++;
			} else {
				sb.append(last);
				if (count > 1) {
					sb.append(count);
				}
				// update last and reset count
				last = input.charAt(i);
				count = 1;
			}
		}
		sb.append(last);
		if (count > 1) {
			sb.append(count);
		}
		return sb.toString();
	}*/
	
	public static void main(String[] args) {
		CompressString test = new CompressString();
		String input = "abbcccdeeef";
		System.out.println(test.compress(input));
	}
}
