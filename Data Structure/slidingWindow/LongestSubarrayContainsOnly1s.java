package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers that contains only 0s and 1s and a positive integer k, you can flip at most k 0s to 1s,
 * return the longest subarray that contains only integer 1 after flipping.
 * 
 * Assumptions: 
 * input is not null
 * 
 * Examples:
 * the longest substring without repeating letters for "bcdfbd" is "bcdf", we should return 4
 * 
 * Time: O(n)
 * Space: O(n)
 */
public class LongestSubarrayContainsOnly1s {
	public int longest(String input) {
		Map<Character, Integer> lastOccurs = new HashMap<>();
		int maxLen = 0;
		int left = 0;
		for (int right = 0; right < input.length(); right++) {
			char cur = input.charAt(right);
			Integer lastOccur = lastOccurs.get(cur);
			if (lastOccur != null && left <= lastOccur) {
				left = lastOccur + 1;
			}
			lastOccurs.put(cur, right); // add or update the last occurrence of the current character
			maxLen = Math.max(maxLen, right - left + 1);
		}		
		return maxLen;
	}
	
	public static void main(String[] args) {
		LongestSubarrayContainsOnly1s test = new LongestSubarrayContainsOnly1s();
		String input = "bcdfbd";
		System.out.println(test.longest(input));
	}
	
	/*public int longest(String input) {
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
	}*/
}
