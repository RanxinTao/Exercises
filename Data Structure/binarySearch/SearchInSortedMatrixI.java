package binarySearch;

import impl.Utils;

/**
 * Given a 2D matrix that contains integers only, which each row is sorted in
 * an ascending order. The first element of next row is larger than (or equal
 * to) the last element of previous row.
 * Given a target number, returning the position that the target locates within
 * the matrix. If the target number does not exist in the matrix, return {-1, -1}
 * 
 * Assumptions:
 * The given matrix is not null, and has size of N * M, where N > 0 and M >= 0.
 * 
 * Examples:
 * matrix = {{1, 2, 3}, {4, 5, 7}, {8, 9, 10}}
 * target = 7, return {1, 2}
 * target = 6, return {-1, -1} to represent the target number does not exist
 * in the matrix.
 * 
 * Time: O(log(N*M))
 * Space: O(1)
 */
public class SearchInSortedMatrixI {
	public int[] search(int[][] matrix, int target) {
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
