package memorizedRecursion;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, return the longest palindrome subsequence.
 * 
 * Examples:
 * 1. s = "abca" Output: 3
 * Explanation: The longest palindrome subsequences could be "aba" or "aca".
 * 
 * Time: O(n^2), where n is the length of the input
 * Space: O(n^2)
 * 
 * Note: compare this one with Longest Palindromic Substring
 */
public class LongestPalindromicSubsequence {
	public int longestPalindrome(String input) {
		return longestPalSub(input, 0, input.length() - 1, new HashMap<Integer, Integer>());
	}
	
	private int longestPalSub(String input, int l, int r, Map<Integer, Integer> memo) {
		if (l == r) {
			return 1;
		}
		if (r < l) {
			return 0;
		}
		int key = l * input.length() + r;
		Integer value = memo.get(key);
		if (value != null) {
			return value;
		}
		int longest = 0;
		if (input.charAt(l) == input.charAt(r)) {
			longest = longestPalSub(input, l + 1, r - 1, memo) + 2;
		} else {
			longest = Math.max(longestPalSub(input, l + 1, r, memo), longestPalSub(input, l, r - 1, memo));
		}
		memo.put(key, longest);
		return longest;
	}
	
	public static void main(String[] args) {
		LongestPalindromicSubsequence test = new LongestPalindromicSubsequence();
		String input = "bacacdba"; // 5
		System.out.println(test.longestPalindrome(input));
	}
}
