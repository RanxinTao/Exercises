package largestAreaOf1s;

/**
 * Given a matrix that contains only 1s and 0s, find the largest X shape which contains only 1s, with the same arm 
 * lengths and the four arms joining at the central point.
 * 
 * Assumptions: matrix is not null and has size of N * M, N >= 0 and M >= 0
 * Examples:
 * {{0, 0, 0, 0},
 *  {1, 1, 1, 1},
 *  {0, 1, 1, 1},
 *  {1, 0, 1, 1}}
 * the largest X of 1s has arm length 2.
 */
public class LargestXOf1s {
	public int largest(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		// fill top left to bottom right matrix and top right to bottom left matrix
		int[][] tl_br = new int[rows][cols];
		int[][] tr_bl = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				tl_br[i][j] = matrix[i][j] == 1 ? getNum(tl_br, i - 1, j - 1) + 1 : 0;
				tr_bl[i][j] = matrix[i][j] == 1 ? getNum(tr_bl, i - 1, j + 1) + 1 : 0;
			}
		}
		// fill bottom right to top left matrix and bottom left to top right matrix
		int[][] br_tl = new int[rows][cols];
		int[][] bl_tr = new int[rows][cols];
		for (int i = rows - 1; i >= 0; i--) {
			for (int j = cols - 1; j >= 0; j--) {
				br_tl[i][j] = matrix[i][j] == 1 ? getNum(br_tl, i + 1, j + 1) + 1 : 0;
				bl_tr[i][j] = matrix[i][j] == 1 ? getNum(bl_tr, i + 1, j - 1) + 1 : 0;
			}
		}
		// merge matrix
		int res = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				res = Math.max(res, Math.min(Math.min(tl_br[i][j], tr_bl[i][j]), Math.min(br_tl[i][j], bl_tr[i][j])));
			}
		}
		return res;
	}

	private int getNum(int[][] matrix, int row, int col) {
		if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) {
			return 0;
		}
		return matrix[row][col];
	}
}
