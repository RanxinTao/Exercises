package array2Pointers_oppositeDirection;

/**
 * Given a string S, find the longest palindromic substring in S.
 * 
 * Assumptions:
 * 1. There exists one unique longest palindromic substring.
 * 2. The input S is not null
 * Examples:
 * Input: "abbc", Output: "bb"
 * Input: "abcbcbd", Output: "bcbcb"
 */
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		String res = "";
		int maxLen = 0;	
		for (int i = 0; i < 2 * s.length() - 1; i++) {
			int left = i / 2;
			int right = i / 2;
			if (i % 2 == 1) {
				right++;
			}
			String str = extendPalindrome(s, left, right);
			if (maxLen < str.length()) {
				maxLen = str.length();
				res = str;
			}
		}
		return res;
	}

	private String extendPalindrome(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return s.substring(left + 1, right);
	}
}
