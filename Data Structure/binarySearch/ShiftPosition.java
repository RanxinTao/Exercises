package binarySearch;

/**
 * Given an integer array A, A is sorted in ascending order first then shifted by an arbitrary number of positions, 
 * Find the index of the smallest number.
 * 
 * Assumptions: 
 * There are no duplicate elements in the array
 * 
 * Examples:
 * A = {3, 4, 5, 1, 2}, return 3
 * A = {1, 2, 3, 4, 5}, return 0
 */
public class ShiftPosition {
	public int shiftPosition(int[] array) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int min_index = 0;
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			// if left part is sorted, array[left] is the min value in the left part
			if (array[left] <= array[mid]) {
				min_index = array[min_index] > array[left] ? left : min_index;
				left = mid + 1;
			// if right part is sorted, array[mid] is the min value in the right part
			} else {
				min_index = array[min_index] > array[mid] ? mid : min_index;
				right = mid - 1;
			}
		}
		return min_index;
	}
}
