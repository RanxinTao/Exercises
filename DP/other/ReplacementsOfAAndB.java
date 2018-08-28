package other;

/**
 * Given a string with only character 'a' and 'b', replace some of the characters such that the string becomes in the forms of 
 * all the 'b's are on the right side of all the 'a's. Determine what is the minimum number of replacements needed.
 * 
 * Assumptions:
 * The given string is not null.
 * Examples:
 * "abaab", the minimum number of replacements needed is 1 (replace the first 'b' with 'a' so that the string becomes "aaaab").
 */
public class ReplacementsOfAAndB {
	public int minReplacements(String input) {
		int countA = 0;
		// calculate the total number of 'a'
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == 'a') {
				countA++;
			}
		}
		// initialize minRes as countA, meaning replace all 'A' with 'B'
		int minRes = countA;
		// turn all the characters from 0 to i (inclusive) into 'A' and all the characters from i + 1 to end into 'B'
		int leftA = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == 'a') {
				leftA++;
			}
			// count how many B in the left half
			int leftB = i + 1 - leftA;
			// count how many A in the right half
			int rightA = countA - leftA;
			int curRes = leftB + rightA;
			minRes = Math.min(curRes, minRes);
		}
		return minRes;
	}
}
