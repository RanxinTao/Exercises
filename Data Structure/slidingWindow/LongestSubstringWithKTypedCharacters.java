package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, return the longest contiguous substring that contains exactly k type of characters.
 * Return null if there does not exist such substring.
 * 
 * Assumptions:
 * 1. The given string is not null and guaranteed to have at least k different characters. (so we should never return null?)
 * 2. k > 0.
 * 
 * Examples:
 * 1. input = "aabcc", k = 3, output = "aabcc".
 * 2. input = "aabcccc", k = 2, output = "bcccc".
 * 
 * Thoughts: similar to Problem "Longest Substring With At Most Two Distinct Characters".
 * 
 * Time: O(n)
 * Space: auxiliary O(k)
 */
public class LongestSubstringWithKTypedCharacters {
	public String longest(String input, int k) {
		String res = "";
		Map<Character, Integer> lastIdxMap = new HashMap<>(); // map k characters to their last indices
		int l = 0; // left index
		for (int r = 0; r < input.length(); r++) {
			char curCh = input.charAt(r);
			if (lastIdxMap.containsKey(curCh) || lastIdxMap.size() < k) { // Merged condition: if this character already exists in the sliding window, we can always update because it won't break the k types constraint.
				lastIdxMap.put(curCh, r); // also if this character is a new character in the sliding window and there are still less than k types of characters, we can still add the character.
			} else { // this is a new character and there has already been k typed characters, we need to remove one type character completely before adding a new one.
				char leftCh = input.charAt(l);
				while (lastIdxMap.get(leftCh) != l) { // the last index of the left character is not l, that means l++ won't remove one type character completely so keep doing
					leftCh = input.charAt(++l);
				} // now we find the character which is the last one of a type character
				lastIdxMap.remove(leftCh); // remove the character from the map
				l++; // remove the character from the sliding window
				lastIdxMap.put(curCh, r); // add the new character
			}
			if (res.length() < r + 1 - l) { // check and update the result every time
				res = input.substring(l, r + 1);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		LongestSubstringWithKTypedCharacters test = new LongestSubstringWithKTypedCharacters();
		/*String input = "aabcc";
		int k = 3; // aabcc */
		String input = "aabcccc";
		int k = 2; // bcccc
		System.out.println(test.longest(input, k));
	}
}
