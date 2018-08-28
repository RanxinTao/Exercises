package array2d_layerByLayer;

import impl.Utils;

/**
 * Rotate an N * N matrix clockwise 90 degrees.
 * 
 * Assumptions:
 * matrix is not null and has size of N * N, N >= 0
 * Examples:
 * {{1,  2,  3}
 *  {8,  9,  4}
 *  {7,  6,  5}}
 * after rotation is
 * {{7,  8,  1}
 *  {6,  9,  2}
 *  {5,  4,  3}}
 */
public class RotateMatrix {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int layer = 0; layer < n / 2; layer++) {
			int left = layer;
			int right = n - 2 - layer;
			for (int i = left; i <= right; i++) {
				int tmp = matrix[layer][i];
				matrix[layer][i] = matrix[n - 1 - i][layer];
				matrix[n - 1 - i][layer] = matrix[n - 1 - layer][n - 1 - i];
				matrix[n - 1 - layer][n - 1 - i] = matrix[i][n - 1 - layer];
				matrix[i][n - 1 - layer] = tmp;
			}
		}
	}
	
	public static void main(String[] args) {
		RotateMatrix test = new RotateMatrix();
		//int[][] matrix = new int[][] {{1,2,3}, {8,9,4}, {7,6,5}};
		int[][] matrix = {{}};
		test.rotate(matrix);
		Utils.print2dArray(matrix);
	}
}
