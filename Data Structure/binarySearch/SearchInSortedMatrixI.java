package binarySearch;

import impl.Utils;

public class SearchInSortedMatrixI {
	public int[] search(int[][] matrix, int target) {
		// Assumptions: matrix is not null, and has size of N * M, where N >= 0 and M >= 0
		int[] res = new int[] { -1, -1 };
		int rows = matrix.length;
		int cols = matrix[0].length;
		if (rows == 0 || cols == 0) {
			return res;
		}
		int left = 0;
		int right = rows * cols - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			int row = mid / cols;
			int col = mid % cols;
			if (matrix[row][col] < target) {
				left = mid + 1;
			} else if (matrix[row][col] == target) {
				res[0] = row;
				res[1] = col;
				return res;
			} else {
				right = mid - 1;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		SearchInSortedMatrixI test = new SearchInSortedMatrixI();
		int[][] matrix = {{1,2,3},{4,5,7},{8,9,10}};
		int target = 7;
		Utils.printArray(test.search(matrix, target));
	}
}
