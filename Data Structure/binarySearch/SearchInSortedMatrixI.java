package binarySearch;

import impl.Utils;

public class SearchInSortedMatrixI {
	public int[] search(int[][] matrix, int target) {
		// Assumptions: matrix is not null, and has size of N * M, where N >= 0 and M >= 0
		int rows = matrix.length;
		int cols = matrix[0].length;
		int left = 0;
		int right = rows * cols - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			int row = mid / cols;
			int col = mid % cols;
			if (matrix[row][col] < target) {
				left = mid + 1;
			} else if (matrix[row][col] > target) {
				right = mid - 1;
			} else {
				return new int[] {row, col};
			}
		}
		return new int[] {-1, -1};
	}
	
	public static void main(String[] args) {
		SearchInSortedMatrixI test = new SearchInSortedMatrixI();
		int[][] matrix = {{1,2,3},{4,5,7},{8,9,10}};
		int target = 7;
		Utils.printArray(test.search(matrix, target));
	}
}
