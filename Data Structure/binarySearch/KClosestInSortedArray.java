package binarySearch;

/**
 * Given a target integer T, a non-negative integer K and an integer array A
 * sorted in ascending order, find the K closest numbers to T in A.
 * Return a size K integer array containing the K closest numbers (not indices)
 * in A, sorted in ascending order by the difference between the number and T.
 * 
 * Assumptions:
 * 1. A is not null
 * 2. K is guaranteed to be <= A.length
 * Examples:
 * A = {1, 2, 3}, T = 2, K = 3, return {2, 1, 3} or {2, 3, 1}
 * A = {1, 4, 6, 8}, T = 3, K = 3, return {4, 1, 6}
 * 
 * Time: O(min(logn, K)), Space: O(1)
 */
public class KClosestInSortedArray {
	public int[] kClosest(int[] array, int target, int k) {
		if (array == null || array.length == 0) {
			return new int[0];
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
				left = mid;
				break;
			}
		}
		// if target is not found in the array
		if (left > right) {
			left = right;
		}
		right = left + 1;
		// expand to k elements
		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			if (right >= array.length || (left >= 0 && target - array[left] <= array[right] - target)) {
				res[i] = array[left];
				left--;
			} else {
				res[i] = array[right];
				right++;
			}
		}
		return res;
	}
}
