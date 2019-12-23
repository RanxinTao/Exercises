package check1_longestConsecutive1s;

import impl.Utils;

/**
 * Determine the largest square surrounded by a bunch of matches (each match is either horizontal or vertical), return
 * the length of the largest square. The input is a matrix of points. Each point has one of the following values:
 * 0 - there is no match to its right or bottom.
 * 1 - there is a match to its right.
 * 2 - there is a match to its bottom.
 * 3 - there is a match to its right, and a match to its bottom.
 * 
 * Assumptions: 
 * 1. The given matrix is guaranteed to be of size M * N, where M, N >= 0
 * 
 * Examples: 
 * {{3, 1, 1, 3, 0, 1, 1, 0},
 *  {2, 0, 0, 2, 0, 0, 0, 0},
 *  {3, 1, 3, 0, 0, 0, 0, 0},
 *  {2, 0, 2, 0, 0, 0, 0, 0},
 *  {1, 1, 0, 0, 0, 0, 0, 0}}
 * The largest square has length of 2.
 * 
 * Time: O(n^3)
 * Space: O(n^2)
 */
public class LargestSquareOfMatches {
	public int largestSquareOfMatches(int[][] matrix) {
		int[][] longestConsecutiveMatchesRightToLeft = longestConsecutiveMatchesRightToLeft(matrix);
		int[][] longestConsecutiveMatchesBottomToTop = longestConsecutiveMatchesBottomToTop(matrix);
		int longestEdge = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				for (int k = matrix[0].length - 1; k > 0; k--) {
					if (j + k >= matrix[0].length || i + k >= matrix.length) {
						continue;
					}
					int top = longestConsecutiveMatchesRightToLeft[i][j];
					int left = longestConsecutiveMatchesBottomToTop[i][j];
					int right = longestConsecutiveMatchesBottomToTop[i][j + k];
					int bottom = longestConsecutiveMatchesRightToLeft[i + k][j];
					if (top >= k && left >= k && right >= k && bottom >= k) {
						longestEdge = Math.max(longestEdge, k);
					}
				}
			}
		}
		return longestEdge;
	}
	
	private int[][] longestConsecutiveMatchesRightToLeft(int[][] matrix) {
		int[][] res = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = matrix[0].length - 2; j >= 0; j--) {
				res[i][j] = (matrix[i][j] == 1 || matrix[i][j] == 3) ? res[i][j + 1] + 1 : 0;
			}
		}
		return res;
	}
	
	private int[][] longestConsecutiveMatchesBottomToTop(int[][] matrix) {
		int[][] res = new int[matrix.length][matrix[0].length];
		for (int j = 0; j < matrix[0].length; j++) {
			for (int i = matrix.length - 2; i >= 0; i--) {
				res[i][j] = (matrix[i][j] == 2 || matrix[i][j] == 3) ? res[i + 1][j] + 1 : 0;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		LargestSquareOfMatches test = new LargestSquareOfMatches();
		int[][] matrix = {{3, 1, 1, 3, 0, 1, 1, 0},
				          {2, 0, 0, 2, 0, 0, 0, 0},
				          {3, 1, 3, 0, 0, 0, 0, 0},
				          {2, 0, 2, 0, 0, 0, 0, 0},
				          {1, 1, 0, 0, 0, 0, 0, 0}};
		System.out.println(test.largestSquareOfMatches(matrix));
		System.out.println();
		int[][] res1 = test.longestConsecutiveMatchesRightToLeft(matrix);
		int[][] res2 = test.longestConsecutiveMatchesBottomToTop(matrix);
		Utils.print2dArray(res1);
		System.out.println();
		Utils.print2dArray(res2);
	}
}
