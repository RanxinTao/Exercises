package check1d_largest_longestSub;

/**
 * Given an array A[0]...A[n-1] of integers, find out the length of the longest ascending subsequence.
 * 
 * Assumptions: array is not null
 * 
 * Examples:
 * Input: A = {5, 2, 6, 3, 4, 7, 5} Output: 4, 
 * Because [2, 3, 4, 5] is the longest ascending subsequence.
 * 
 * Time: O(n^2)
 * Space: O(n)
 */
public class LongestAscendingSubsequence {
	public int longest(int[] array) {
		int[] longest = new int[array.length]; // longest[i] = the length of longest ascending subsequence ending at index i
		int res = 0; // records the length of longest subsequence so far
		for (int i = 0; i < longest.length; i++) {
			longest[i] = 1; // initialize longest[i] as 1, since the shortest one has length 1
			for (int j = 0; j < i; j++) {
				if (array[i] > array[j]) {
					longest[i] = Math.max(longest[i], longest[j] + 1);
				}
			}
			res = Math.max(res, longest[i]);
		}
		return res;
	}
	
	public static void main(String[] args) {
		LongestAscendingSubsequence test = new LongestAscendingSubsequence();
		int[] array = {5, 2, 6, 3, 4, 7, 5};
		System.out.println(test.longest(array));
	}
}
