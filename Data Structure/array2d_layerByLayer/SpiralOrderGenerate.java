package array2d_layerByLayer;

import impl.Utils;

/**
 * Assumptions: M, N >= 0
 * Examples: M = 3, N = 4, the generated matrix is
 * {{1, 2, 3, 4},
 *  {10, 11, 12, 5},
 *  {9, 8, 7, 6}}
 */
public class SpiralOrderGenerate {
	public int[][] spiralGenerate(int m, int n) {
		int[][] res = new int[m][n];
		if (m == 0 || n == 0) {
			return res;
		}
		int top = 0;
		int bottom = m - 1;
		int left = 0;
		int right = n - 1;
		int num = 1;
		// spiral order traverse
		while (top < bottom && left < right) {
			for (int i = left; i < right; i++) {
				res[top][i] = num++;
			}
			for (int i = top; i < bottom; i++) {
				res[i][right] = num++;
			}
			for (int i = right; i > left; i--) {
				res[bottom][i] = num++;
			}
			for (int i = bottom; i > top; i--) {
				res[i][left] = num++;
			}
			top++;
			right--;
			bottom--;
			left++;
		}
		// if there is one row left
		if (top == bottom) {
			for (int i = left; i <= right; i++) {
				res[top][i] = num++;
			}
		// if there is one column left
		} else if (left == right) {
			for (int i = top; i <= bottom; i++) {
				res[i][left] = num++;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		SpiralOrderGenerate test = new SpiralOrderGenerate();
		int m = 3;
		int n = 4;
		Utils.print2dArray(test.spiralGenerate(m, n));
	}
}
