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
		Map<Character, Integer> map = new HashMap<>();
		int maxLen = 0;
		int left = 0;
		for (int right = 0; right < input.length(); right++) {
			char cur = input.charAt(right);
			Integer lastOccurrence = map.get(cur);
			if (lastOccurrence != null && left <= lastOccurrence) {
				maxLen = Math.max(maxLen, right - left);
				left = lastOccurrence + 1;
			}
			map.put(cur, right);
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
