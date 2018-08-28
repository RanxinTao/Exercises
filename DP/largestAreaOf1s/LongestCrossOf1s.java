package largestAreaOf1s;

/**
 * Given a matrix that contains only 1s and 0s, find the largest cross which contains only 1s, 
 * with the same arm lengths and the four arms joining at the central point. Return the arm length of the largest cross.
 * 
 * Assumptions: matrix is not null and has size of N * M, N >= 0 and M >= 0
 * Examples:
 * {{0, 0, 0, 0},
 *  {1, 1, 1, 1},
 *  {0, 1, 1, 1},
 *  {1, 0, 1, 1}}
 *  the largest cross of 1s has arm length 2.
 */
public class LongestCrossOf1s {
	public int largest(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;	
		// fill left to right matrix and right to left matrix
		int[][] lr = new int[rows][cols];
		int[][] rl = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			lr[i][0] = matrix[i][0];
			rl[i][cols - 1] = matrix[i][cols - 1];
			for (int j = 1; j < cols; j++) {
				lr[i][j] = matrix[i][j] == 1 ? lr[i][j - 1] + 1 : 0;
				rl[i][cols - 1 - j] = matrix[i][cols - 1 - j] == 1 ? rl[i][cols - j] + 1 : 0;
			}
		}
		// fill top to bottom matrix and bottom to top matrix
		int[][] tb = new int[rows][cols];
		int[][] bt = new int[rows][cols];
		for (int j = 0; j < cols; j++) {
			tb[0][j] = matrix[0][j];
			bt[rows - 1][j] = matrix[rows - 1][j];
			for (int i = 1; i < rows; i++) {
				tb[i][j] = matrix[i - 1][j] == 1 ? tb[i - 1][j] + 1 : 0;
				bt[rows - 1 - i][j] = matrix[rows - 1 - i][j] == 1 ? bt[rows - i][j] + 1 : 0;
			}
		}
		// merge matrix
		int res = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				res = Math.max(res, Math.min(Math.min(lr[i][j], rl[i][j]), Math.min(tb[i][j], bt[i][j])));
			}
		}
		return res;
	}
}
