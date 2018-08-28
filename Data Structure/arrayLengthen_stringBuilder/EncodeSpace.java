package arrayLengthen_stringBuilder;

/**
 * In URL encoding, whenever we see an space " ", we need to replace it with "20%". Provide a method that 
 * performs this encoding for a given string.
 * 
 * Examples:
 * "google/q?flo wer market" ¡ú "google/q?flo20%wer20%market"
 */
public class EncodeSpace {
	public String encode(String input) {
		if (input == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			char cur = input.charAt(i);
			if (cur == ' ') {
				sb.append("20%");
			} else {
				sb.append(cur);
			}
		}
		return sb.toString();
	}
}
