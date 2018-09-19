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
public class MinimumCutsForPalindromes_Hash {
	public int minCuts(String input) {
		if (input.length() == 0) {
			return 0;
		}
		// indicates min cut for the substring from index 0 to end (both inclusive)
		Integer[] minCuts = new Integer[input.length()];
		Boolean[][] isPal = new Boolean[input.length()][input.length()];
		return minCuts(input.length() - 1, input, minCuts, isPal);
	}
	
	private int minCuts(int end, String input, Integer[] minCuts, Boolean[][] isPal) {
		if (minCuts[end] != null) {
			return minCuts[end];
		} else if (isPal(0, end, input, isPal)) {
			minCuts[end] = 0;
			return 0;
		} else { // if the current string is not a palindrome
			int minCut = end;
			for (int i = 0; i < end; i++) {
				if (isPal(i + 1, end, input, isPal)) { 
					minCut = Math.min(minCut, minCuts(i, input, minCuts, isPal) + 1);
				}
			}
			minCuts[end] = minCut;
			return minCut;
		}
	}
	
	// check if the substring from index start to end (both inclusive) is a palindrome
	private boolean isPal(int start, int end, String input, Boolean[][] isPal) {
		if (isPal[start][end] != null) {
			return isPal[start][end];
		} else if (start == end) {
			isPal[start][end] = true;
			return true;
		} else if ((end - start == 1 || isPal(start + 1, end - 1, input, isPal)) && input.charAt(start) == input.charAt(end)) {
			isPal[start][end] = true;
			return true;
		} else {
			isPal[start][end] = false;
			return false;
		}
	}
	
	public static void main(String[] args) {
		MinimumCutsForPalindromes_Hash test = new MinimumCutsForPalindromes_Hash();
		System.out.println(test.minCuts("bb"));
	}
}
