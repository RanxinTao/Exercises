package binarySearch;

/**
 * Given a target integer T and an integer array A sorted in ascending order, Find the total number of 
 * occurrences of T in A.
 *
 * Examples:
 * A = {1, 2, 3, 4, 5}, T = 3, return 1
 * A = {1, 2, 2, 2, 3}, T = 2, return 3
 * A = {1, 2, 2, 2, 3}, T = 4, return 0
 */
public class TotalOccurrence {
	public int totalOccurrence(int[] array, int target) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int min_index = findOccurrence(array, target, true);
		return min_index == -1 ? 0 : findOccurrence(array, target, false) - min_index + 1;
	}

	private int findOccurrence(int[] array, int target, boolean first) {
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (array[mid] < target) {
				left = mid + 1;
			} else if (array[mid] > target) {
				right = mid - 1;
			} else if (first) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		if (left < array.length && array[left] == target) {
			return left;
		} else if (right >= 0 && array[right] == target) {
			return right;
		} else {
			return -1;
		}
	}
}
