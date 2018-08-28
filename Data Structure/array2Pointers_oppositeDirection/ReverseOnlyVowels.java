package array2Pointers_oppositeDirection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Only reverse the vowels('a', 'e', 'i', 'o', 'u') in a given string, the other characters should not be moved or changed.
 * 
 * Assumptions:
 * The given string is not null, and only contains lower case letters.
 * Examples:
 * "abbegi" --> "ibbega"
 */
public class ReverseOnlyVowels {
	public String reverse(String input) {
		Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
		char[] charArray = input.toCharArray();
		int left = 0;
		int right = charArray.length - 1;
		while (left < right) {
			if (!vowels.contains(charArray[left])) {
				left++;
			} else if (!vowels.contains(charArray[right])) {
				right--;
			} else {
				// swap charArray[left] and charArray[right]
				char tmp = charArray[left];
				charArray[left] = charArray[right];
				charArray[right] = tmp;
				left++;
				right--;
			}
		}
		return new String(charArray);
	}
}
