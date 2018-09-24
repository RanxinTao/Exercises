package arrays_2Pointers;

/**
 * Assumptions:
 * 1. The original string only contains alphabetic characters.
 * 2. input, pattern are not null.
 */
public class StringAbbreviationMatching {
	public boolean match(String input, String pattern) {
		int ii = 0;
		int pi = 0;
		while (ii < input.length() && pi < pattern.length()) {
			if (isDigit(pattern.charAt(pi))) {
				int count = 0;
				while (pi < pattern.length() && isDigit(pattern.charAt(pi))) {
					count = 10 * count + pattern.charAt(pi) - '0';
					pi++;
				}
				ii += count;
			} else {
				if (pattern.charAt(pi) != input.charAt(ii)) {
					return false;
				}
				ii++;
				pi++;
			}
		}
		return ii == input.length() && pi == pattern.length();
	}

	private boolean isDigit(char ch) {
		return ch >= '0' && ch <= '9';
	}
}
