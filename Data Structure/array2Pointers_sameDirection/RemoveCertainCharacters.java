package array2Pointers_sameDirection;

import java.util.HashSet;
import java.util.Set;

/**
 * Remove given characters in input string, the relative order of other characters should be remained. 
 * Return the new string after deletion.
 *
 * Assumptions:
 * 1. The given input string is not null.
 * 2. The characters to be removed is given by another string, it is guaranteed to be not null.
 * 
 * Examples:
 * input = "abcd", t = "ab", delete all instances of 'a' and 'b', the result is "cd".
 * 
 * Time: O(m + n), where m is the length of input, n is the length of t
 * Space: O(n)
 */
public class RemoveCertainCharacters {
	public String remove(String input, String t) {
		// build HashSet
		Set<Character> toRemove = buildSet(t);		
		// iterate through array and remove certain characters
		char[] charArr = input.toCharArray();
		int end = 0; // the left to end (exclusive) are to be kept 
		for (int i = 0; i < input.length(); i++) {
			if (!toRemove.contains(charArr[i])) {
				charArr[end] = charArr[i];
				end++;
			}
		}
		return new String(charArr, 0, end);
	}
	
	private Set<Character> buildSet(String t) {
		Set<Character> charSet = new HashSet<>();
		for (int i = 0; i < t.length(); i++) {
			charSet.add(t.charAt(i));
		}
		return charSet;
	}
	
	public static void main(String[] args) {
		RemoveCertainCharacters test = new RemoveCertainCharacters();
		String input = "abcd";
		String t = "ab";
		System.out.println(test.remove(input, t));
	}
}
