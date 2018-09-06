package arrayLengthen_stringBuilder;

/**
 * Given a string in compressed form, decompress it to the original string. The adjacent repeated characters 
 * in the original string are compressed to have the character followed by the number of repeated occurrences.
 * 
 * Assumptions: 
 * 1. The string is not null
 * 2. The characters used in the original string are guaranteed to be ¡®a¡¯ - ¡®z¡¯
 * 3. There are no adjacent repeated characters with length > 9
 * Examples:
 * input = "a1c0b2c4" -> "abbcccc"
 */
public class DecompressStringII {
	public String decompress(String input) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			char cur = input.charAt(i);
			i++;
			int count = input.charAt(i) - '0';
			while (count > 0) {
				sb.append(cur);
				count--;
			}
		}
		return sb.toString();
	}
}
