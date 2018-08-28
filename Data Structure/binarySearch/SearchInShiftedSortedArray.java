package binarySearch;

/**
 * Given a target integer T and an integer array A, A is sorted in ascending order first, then shifted by an arbitrary 
 * number of positions. For Example, A = {3, 4, 5, 1, 2} (shifted left by 2 positions). Find the index i such that 
 * A[i] == T or return -1 if there is no such index.
 * 
 * Assumptions: 
 * There could be duplicate elements in the array.
 * 
 * Examples:
 * A = {3, 4, 5, 1, 2}, T = 4, return 1
 * A = {3, 3, 3, 1, 3}, T = 1, return 3
 * A = {3, 1, 3, 3, 3}, T = 1, return 1
 */
public class SearchInShiftedSortedArray {
	public int search(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (array[mid] == target) {
				return mid;
			// if left part is sorted
			} else if (array[left] < array[mid]) {
				if (target >= array[left] && target < array[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			// if right part is sorted
			} else if (array[mid] < array[left]) {
				if (target > array[mid] && target <= array[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			// array[left] == array[mid], in this case we don't know which side is sorted
			} else {
				left++;
			}
		}
		return -1;
	}
}
