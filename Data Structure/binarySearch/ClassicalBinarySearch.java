package binarySearch;

/**
 * Given a target integer T and an integer array A sorted in ascending order, find the index i such that A[i] == T or 
 * return -1 if there is no such index.
 * 
 * Assumptions:
 * There can be duplicate elements in the array, in this case return any of the 
 * indices i such that A[i] == T.
 * 
 * Examples:
 * 1. A = {1, 2, 3, 4, 5}, T = 3, return 2
 * 2. A = {1, 2, 3, 4, 5}, T = 6, return -1
 * 3. A = {1, 2, 2, 2, 3, 4}, T = 2, return 1 or 2 or 3
 * 
 * Time: O(logn)
 * Space: O(1)
 */
public class ClassicalBinarySearch {
	public int binarySearch(int[] array, int target) {
		if (array == null) {
			return -1;
		}
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (array[mid] < target) {
				left = mid + 1;
			} else if (array[mid] > target) {
				right = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
