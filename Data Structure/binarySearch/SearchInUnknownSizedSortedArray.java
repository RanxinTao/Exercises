package binarySearch;

/**
 * Given a target dictionary A of unknown size, where the numbers in the dict
 * are sorted in ascending order, determine if a given target integer T is in
 * the dict.
 * Return the index of T in A, return -1 if T is not in A.
 * 
 * Assumptions:
 * 1. dict A is not null.
 * 2. dict.get(i) will return null if index i is out of bounds.
 * 
 * Examples:
 * A = {1, 2, 5, 9, ......}, T = 5, return 2
 * A = {1, 2, 5, 9, 12, ......}, T = 7, return -1
 * 
 * Time: O(logn)
 * Space: O(1)
 */
public class SearchInUnknownSizedSortedArray {
	public int search(Dictionary dict, int target) {
		// Assumptions: dict is not null
		// dict.get(i) will return null if index i is out of bounds
		if (dict == null) {
			return -1;
		}
		int left = 0;
		int right = 1;
		while (dict.get(right) != null && dict.get(right) < target) {
			left = right;
			right = 2 * right;
		}
		// binary search
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (dict.get(mid) == null || dict.get(mid) > target) {
				right = mid - 1;
			} else if (dict.get(mid) < target) {
				left = mid + 1;			
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	interface Dictionary {
		public Integer get(int index);
	}
}
