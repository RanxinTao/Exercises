package check1d_largest_longestSub;

/**
 * Given an array A[0]...A[n-1] of integers, count the number of ascending subsequences.
 * In case that the result is larger than 32-bit integer, return the result in 10^9+7 modulo.
 * 
 * Assumptions: A is not null
 * 
 * Examples:
 * Input: A = {1, 2, 3} Output: 7
 * Explanation: [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]
 * 
 * Induction Rule:
 * numAscSubseq(i) = 1 + summation(numAscSubseq(j)) where j is index of all elements such that
 * a[j] < a[i] and j < i
 * 
 * Time: O(n^2)
 * Space: O(n)
 * 
 * References:
 * 1. https://www.geeksforgeeks.org/count-all-increasing-subsequences/
 * 2. https://www.geeksforgeeks.org/count-number-of-increasing-sub-sequences-onlogn/
 */
public class CountAscendingSubsequence {
	public int numIncreasingSubsequences(int[] a) {
		int[] numAscSubseq = new int[a.length];
		for (int i = 0; i < numAscSubseq.length; i++) {
			int sum = 0;
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j]) {
					sum += numAscSubseq[j];
				}
			}
			numAscSubseq[i] = sum + 1;
		}
		int res = 0;
		for (int i = 0; i < numAscSubseq.length; i++) {
			res += numAscSubseq[i];
		}
		return res;
	}
	
	public static void main(String[] args) {
		CountAscendingSubsequence test = new CountAscendingSubsequence();
		int[] array = {1, 2, 3};
		System.out.println(test.numIncreasingSubsequences(array));
	}
}
