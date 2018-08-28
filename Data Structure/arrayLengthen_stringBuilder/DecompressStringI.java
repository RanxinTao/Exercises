package arrayLengthen_stringBuilder;

/**
 * Given a string in compressed form, decompress it to the original string. The adjacent repeated characters in the original 
 * string are compressed to have the character followed by the number of repeated occurrences. If the character does not have 
 * any adjacent repeated occurrences, it is not compressed.
 * 
 * Assumptions: 
 * 1. The string is not null
 * 2. The characters used in the original string are guaranteed to be ¡®a¡¯ - ¡®z¡¯
 * 3. There are no adjacent repeated characters with length > 9
 * Examples:
 * ¡°acb2c4¡± ¡ú ¡°acbbcccc¡±
 */
public class DecompressStringI {
	public String decompress(String input) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			char cur = input.charAt(i);
			int count = 1;
			if (i + 1 < input.length() && input.charAt(i + 1) > '0' && input.charAt(i + 1) <= '9') {
				i++;
				count = input.charAt(i) - '0';
			}
			while (count > 0) {
				sb.append(cur);
				count--;
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		DecompressStringI test = new DecompressStringI();
		String input = "acb2c4";
		System.out.println(test.decompress(input));
	}
}
