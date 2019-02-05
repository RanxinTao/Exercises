package binarySearch;

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
