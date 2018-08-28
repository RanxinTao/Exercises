package binarySearch;

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
			} else if (dict.get(mid) == target) {
				return mid;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}
	
	interface Dictionary {
		public Integer get(int index);
	}
}
