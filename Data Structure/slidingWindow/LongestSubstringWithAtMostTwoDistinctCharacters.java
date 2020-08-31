package slidingWindow;

/**
 * Given a string, find the length of the longest substring T that contains at most 2 distinct 
 * characters.
 * 
 * Examples:
 * 1. Given s = "eceba", T is "ece", return 3
 * 
 * Thoughts: we don't have to store the 2 distinct characters, instead of themselves, we store their
 * indices in the input string.
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
	public int lengthOfLongestSubstringTwoDistinct(String input) {
		int maxLen = 0;	
		int lastIdx1 = -1; // last index of character 1
		int lastIdx2 = -1; // last index of character 2
		int l = 0; // left index
		for (int r = 0; r < input.length(); r++) {
			char cur = input.charAt(r);
			if (lastIdx1 == -1 || input.charAt(lastIdx1) == cur) {
				lastIdx1 = r;
			} else if (lastIdx2 == -1 || input.charAt(lastIdx2) == cur) {
				lastIdx2 = r;
			} else { // ch1 != 0 && ch2 != 0 && curCh != ch1 && curCh != ch2
				l = lastIdx1 + 1;
				lastIdx1 = lastIdx2; // we maintain ch1 in the left side of ch2, so we can always replace ch1 with the new character
				lastIdx2 = r;
			}
			maxLen = Math.max(maxLen, r - l + 1);
		}
		return maxLen;
	}
	
	public static void main(String[] args) {
		LongestSubstringWithAtMostTwoDistinctCharacters test = new LongestSubstringWithAtMostTwoDistinctCharacters();
		String input = "aaaaaabdcdd";
		//String input = "eceba";
		System.out.println(test.lengthOfLongestSubstringTwoDistinct(input));
	}
}
