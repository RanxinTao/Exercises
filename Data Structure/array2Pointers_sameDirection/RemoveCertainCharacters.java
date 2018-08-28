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
		char[] array = input.toCharArray();
		// build HashSet
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < t.length(); i++) {
			set.add(t.charAt(i));
		}
		// iterate through array and remove certain characters
		int end = 0;
		for (int i = 0; i < input.length(); i++) {
			if (!set.contains(array[i])) {
				array[end] = array[i];
				end++;
			}
		}
		return new String(array, 0, end);
	}
	
	public static void main(String[] args) {
		RemoveCertainCharacters test = new RemoveCertainCharacters();
		String input = "abcd";
		String t = "ab";
		System.out.println(test.remove(input, t));
	}
}
