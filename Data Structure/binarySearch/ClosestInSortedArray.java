package binarySearch;

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
			} else if (array[mid] == target) {
				return mid;
			} else {
				right = mid - 1;
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
