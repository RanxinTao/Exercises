package cuttingProblems_largeSmallHalf;

/**
 * Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition 
 * is a palindrome. Determine the fewest cuts needed for a palindrome partitioning of a given string.
 * 
 * Assumptions: 
 * input is not null
 * Examples:
 * ¡°a | babbbab | bab | aba¡± is a palindrome partitioning of ¡°ababbbabbababa¡±.
 * The minimum number of cuts needed is 3.
 */
public class MinimumCutsForPalindromes {
	public int minCuts(String input) {
		if (input.length() == 0) {
			return 0;
		}
		// isPal[i][j] indicates if the substring which starts from i to j (both inclusive) is palindrome
		boolean[][] isPal = palindromes(input);
		// minCuts[i] indicates the min cuts for the substring from 0 to i (both inclusive)
		int[] minCuts = new int[input.length()];
		// minCuts[0] = 0, so fill the array from 1
		for (int i = 1; i < input.length(); i++) {
			if (!isPal[0][i]) {
				// min cut of the non-palindrome substring from 0 to i (both inclusive) is i (cut between every single character)
				minCuts[i] = i;
				for (int j = 0; j < i; j++) {
					if (isPal[j + 1][i]) { // if substring from j + 1 to i is a palindrome
						minCuts[i] = Math.min(minCuts[i], minCuts[j] + 1);
					}
				}
			}
		}
		return minCuts[input.length() - 1];
	}

	private boolean[][] palindromes(String input) {
		boolean[][] isPal = new boolean[input.length()][input.length()];
		for (int end = 0; end < input.length(); end++) {
			for (int start = 0; start <= end; start++) {
				if (start == end || 
						(end - start == 1 || isPal[start + 1][end - 1]) 
						&& input.charAt(start) == input.charAt(end)) {
					isPal[start][end] = true;
				}
			}
		}
		return isPal;
	}
}
