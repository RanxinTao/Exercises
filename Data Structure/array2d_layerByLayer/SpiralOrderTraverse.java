package array2d_layerByLayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Assumptions: matrix is not null and has size of M * N where M, N >= 0
 * Examples:
 * {{1, 2, 3, 4},
 *  {5, 6, 7, 8},
 *  {9, 10, 11, 12}}
 * the traversal sequence is [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
 */
public class SpiralOrderTraverse {
	public List<Integer> spiral(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		if (matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}
		int top = 0;
		int bottom = matrix.length - 1;
		int left = 0;
		int right = matrix[0].length - 1;
		// spiral order traverse
		while (top < bottom && left < right) {
			for (int i = left; i < right; i++) {
				res.add(matrix[top][i]);
			}
			for (int i = top; i < bottom; i++) {
				res.add(matrix[i][right]);
			}
			for (int i = right; i > left; i--) {
				res.add(matrix[bottom][i]);
			}
			for (int i = bottom; i > top; i--) {
				res.add(matrix[i][left]);
			}
			top++;
			right--;
			bottom--;
			left++;
		}
		// if there is one row left
		if (top == bottom) {
			for (int i = left; i <= right; i++) {
				res.add(matrix[top][i]);
			}
		// if there is one column left
		} else if (left == right) {
			for (int i = top; i <= bottom; i++) {
				res.add(matrix[i][left]);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		SpiralOrderTraverse test = new SpiralOrderTraverse();
		int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
		//int[][] matrix = {{1}};
		System.out.println(test.spiral(matrix));
	}
}
