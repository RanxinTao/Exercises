package array2d_layerByLayer;

import java.util.ArrayList;
import java.util.List;

import impl.Utils;

/**
 * Rotate an N * N matrix clockwise 90 degrees.
 * 
 * Assumptions:
 * The matrix is not null and has size of N * N, N >= 0
 * 
 * Examples:
 * {{1,  2,  3}
 *  {8,  9,  4}
 *  {7,  6,  5}}
 * after rotation is
 * {{7,  8,  1}
 *  {6,  9,  2}
 *  {5,  4,  3}}
 *  
 * Time: O(n^2)
 * Space: O(1)
 */
public class RotateMatrix {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		int top = 0;
		int bottom = n - 1;
		int left = 0;
		int right = n - 1;
		while (top < bottom) {
			for (int offset = 0; offset < right - left; offset++) {
				int tmp = matrix[top][left + offset];
				matrix[top][left + offset] = matrix[bottom - offset][left];
				matrix[bottom - offset][left] = matrix[bottom][right - offset];
				matrix[bottom][right - offset] = matrix[top + offset][right];
				matrix[top + offset][right] = tmp;
			}
			top++;
			right--;
			bottom--;
			left++;
		}
	}
	
	/*public void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int layer = 0; layer < n / 2; layer++) { // layer is a spiral level
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
	}*/
	
	public static void main(String[] args) {
		RotateMatrix test = new RotateMatrix();
		int[][] matrix = new int[][] {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
		//int[][] matrix = {{}};
		test.rotate(matrix);
		Utils.print2dArray(matrix);
	}
}
