package binarySearch;

/**
 * Given a target integer T and an integer array A sorted in ascending order,
 * find the index i such that A[i] is closest to T.
 * 
 * Assumptions:
 * There can be duplicate elements in the array, in this case return any of the 
 * indices with same value.
 * Examples:
 * A = {1, 2, 3}, T = 2, return 1
 * A = {1, 4, 6}, T = 3, return 1
 * A = {1, 4, 6}, T = 5, return 1 or 2
 * A = {1, 3, 3, 4}, T = 2, return 0 or 1 or 2
 * 
 * Time: O(logn), Space: O(1)
 */
public class ClosestInSortedArray {
	public int closest(int[] array, int target) {
		if (array == null || array.length == 0) {
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
		if (left >= array.length) {
			return right;
		} else if (right < 0) {
			return left;
		} else {
			return array[left] - target > target - array[right] ? right : left;
		}
	}
}
