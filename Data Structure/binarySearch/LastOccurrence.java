package binarySearch;

public class LastOccurrence {
	public int lastOccur(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (array[mid] <= target) {
				left = mid + 1;
			} else {
				right = mid - 1;
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
