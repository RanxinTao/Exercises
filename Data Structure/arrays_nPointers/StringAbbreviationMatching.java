package arrays_nPointers;

/**
 * Word "book" can be abbreviated to 4, b3, b2k, etc. Given a string and an abbreviation, return if the string matches
 * the abbreviation.
 * 
 * Assumptions:
 * 1. The original string only contains alphabetic characters.
 * 2. Both input and pattern are not null.
 * 3. Pattern would not contain invalid information like "a0a", "0".
 * 
 * Examples:
 * pattern "s11d" matches input "sophisticated" since "11" match eleven chars "ophisticate".
 * 
 * Time: O(m + n) where m is the length of the input string and n is the length of the pattern
 * Space: O(1)
 */
public class StringAbbreviationMatching {
	public boolean match(String input, String pattern) {
		int ii = 0;
		int pi = 0;
		while (ii < input.length() && pi < pattern.length()) {
			if (Character.isDigit(pattern.charAt(pi))) {
				int count = 0;
				while (pi < pattern.length() && Character.isDigit(pattern.charAt(pi))) {
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
}
