package slidingWindow;

/**
 * Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
 * 
 * Examples:
 * 1. Given s = "eceba", T is "ece", return 3
 * 
 * Thoughts: we don't have to store the 2 distinct characters, instead of themselves, we store their indices in the input string.
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
	public int lengthOfLongestSubstringTwoDistinct(String input) {
		int maxLen = 0;
		int left = 0;
		int lastIdx1 = -1; // last index of character 1
		int lastIdx2 = -1; // last index of character 2
		for (int right = 0; right < input.length(); right++) {
			char cur = input.charAt(right);
			if (lastIdx1 == -1 || input.charAt(lastIdx1) == cur) {
				lastIdx1 = right;
			} else if (lastIdx2 == -1 || input.charAt(lastIdx2) == cur) {
				lastIdx2 = right;
			} else { // ch1 != 0 && ch2 != 0 && curCh != ch1 && curCh != ch2
				left = lastIdx1 + 1;
				lastIdx1 = lastIdx2; // we maintain ch1 to be on the left side of ch2, so we always know ch1 is to be replaced by the new character
				lastIdx2 = right;
			}
			maxLen = Math.max(maxLen, right - left + 1);
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
