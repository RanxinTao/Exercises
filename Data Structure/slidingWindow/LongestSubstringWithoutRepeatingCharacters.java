package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Assumptions: input is not null
 * Examples: the longest substring without repeating letters for "bcdfbd" is "bcdf", we should return 4
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public int longest(String input) {
		if (input.length() == 0) {
			return 0;
		}
		Map<Character, Integer> lastOccurs = new HashMap<>();
		int maxLen = 0;
		int left = 0;
		for (int right = 0; right < input.length(); right++) {
			char cur = input.charAt(right);
			Integer lastOccur = lastOccurs.get(cur);
			if (lastOccur != null && left <= lastOccur) {
				maxLen = Math.max(maxLen, right - left);
				left = lastOccur + 1;
			}
			// add or update the last occurrence of the current character
			lastOccurs.put(cur, right);
		}
		maxLen = Math.max(maxLen, input.length() - left);
		return maxLen;
	}
	
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters test = new LongestSubstringWithoutRepeatingCharacters();
		String input = "bcdfbd";
		System.out.println(test.longest(input));
	}
}
