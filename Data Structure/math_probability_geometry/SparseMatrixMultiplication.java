package math_probability_geometry;

/**
 * Given two sparse matrices A and B, return the result of AB.
 * Note: sparse means there are a lot of 0s in both matrices
 * 
 * Assumptions:
 * 1. A's column number is equal to B's row number.
 * 
 * Examples:
 * 1. A = [[1, 0, 0],	
 *         [-1, 0, 3]]
 *    B = [[7, 0, 0],
 *         [0, 0, 0],
 *         [0, 0, 1]]
 *    AB = [[1, 0, 0],	  [[7, 0, 0],     [[7, 0, 0],
 *         [-1, 0, 3]]  *  [0, 0, 0],  =   [-7, 0, 3]]
 *                         [0, 0, 1]]
 * 
 * Time: O(lmn), where l is the number of columns of A, m is the number of rows of A, and n is the number of columns of B
 * Space: auxiliary O(1)
 * 
 * Reference: another solutions uses hash map: https://www.cnblogs.com/yrbbest/p/5060667.html
 */
public class SparseMatrixMultiplication {
	public int[][] multiply(int[][] A, int[][] B) {
		int m = A.length; // the number of rows, A decides the row number of the result
		int n = B[0].length; // the number of cols, B decides the col number of the result
		int[][] res = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int k = 0; k < A[0].length; k++) { // A[0].length = B.length
				if (A[i][k] != 0) {
					for (int j = 0; j < n; j++) {
						if (B[k][j] != 0) {
							res[i][j] += A[i][k] * B[k][j];
						}
					}
				}
			}
		}
		return res;
	}
}
