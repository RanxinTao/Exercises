package array2Pointers_sameDirection;

import java.util.HashSet;
import java.util.Set;

/**
 * Assumptions: input, t are not null
 */
public class RemoveCertainCharacters {
	public String remove(String input, String t) {
		if (input.isEmpty() || t.isEmpty()) {
			return input;
		}
		// build HashSet
		Set<Character> charSet = buildSet(t);		
		// iterate through array and remove certain characters
		char[] charArr = input.toCharArray();
		int end = 0; // the left to end (exclusive) are to be kept 
		for (int i = 0; i < input.length(); i++) {
			if (!charSet.contains(charArr[i])) {
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
