package binarySearch;

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
