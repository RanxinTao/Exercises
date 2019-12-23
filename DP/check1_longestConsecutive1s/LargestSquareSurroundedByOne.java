package check1_longestConsecutive1s;

import impl.Utils;

/**
 * Determine the largest square surrounded by 1s in a binary matrix (a binary matrix only contains 0 and 1), 
 * return the length of the largest square.
 * 
 * Assumptions: 
 * 1. The given matrix is guaranteed to be of size M * N, where M, N >= 0
 * 
 * Examples: 
 * {{1, 0, 1, 1, 1},
 *  {1, 1, 1, 1, 1},
 *  {1, 1, 0, 1, 0},
 *  {1, 1, 1, 1, 1},
 *  {1, 1, 1, 0, 0}}
 * The largest square surrounded by 1s has length of 3.
 * 
 * Time: O(n^3)
 * Space: O(n^2)
 */
public class LargestSquareSurroundedByOne {
	public int largestSquareSurroundedByOne(int[][] matrix) {
		int[][] longestConsecutive1sRightToLeft = longestConsecutive1sRightToLeft(matrix);
		int[][] longestConsecutive1sBottomToTop = longestConsecutive1sBottomToTop(matrix);
		int longestEdge = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				for (int k = matrix[0].length - 1; k >= 0; k--) { // length of the edge: from 0 to matrix[0].length - 1, = 0 means 1 element forms a square.
					if (j + k >= matrix[0].length || i + k >= matrix.length) {
						continue;
					}
					int top = longestConsecutive1sRightToLeft[i][j];
					int left = longestConsecutive1sBottomToTop[i][j];
					int right = longestConsecutive1sBottomToTop[i][j + k];
					int bottom = longestConsecutive1sRightToLeft[i + k][j];
					if (top >= k + 1 && left >= k + 1 && right >= k + 1 && bottom >= k + 1) { // don't forget + 1
						longestEdge = Math.max(longestEdge, k + 1);
					}
				}
			}
		}
		return longestEdge;
	}
	
	private int[][] longestConsecutive1sRightToLeft(int[][] matrix) {
		int[][] res = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = matrix[0].length - 1; j >= 0; j--) {
				if (j == matrix[0].length - 1) {
					res[i][j] = matrix[i][j];
				} else {
					res[i][j] = matrix[i][j] == 0 ? 0 : res[i][j + 1] + 1;
				}	
			}
		}
		return res;
	}
	
	private int[][] longestConsecutive1sBottomToTop(int[][] matrix) {
		int[][] res = new int[matrix.length][matrix[0].length];
		for (int j = 0; j < matrix[0].length; j++) {
			for (int i = matrix.length - 1; i >= 0; i--) {
				if (i == matrix.length - 1) {
					res[i][j] = matrix[i][j];
				} else {
					res[i][j] = matrix[i][j] == 0 ? 0 : res[i + 1][j] + 1;
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		LargestSquareSurroundedByOne test = new LargestSquareSurroundedByOne();
		int[][] matrix = {{0, 1, 0, 0},
				          {1, 1, 0, 0},
				          {0, 1, 0, 1},
				          {0, 0, 1, 1}};
		System.out.println(test.largestSquareSurroundedByOne(matrix));
		System.out.println();
		int[][] res1 = test.longestConsecutive1sRightToLeft(matrix);
		int[][] res2 = test.longestConsecutive1sBottomToTop(matrix);
		Utils.print2dArray(res1);
		System.out.println();
		Utils.print2dArray(res2);
	}
}
