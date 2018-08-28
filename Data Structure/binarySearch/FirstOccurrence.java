package binarySearch;

public class FirstOccurrence {
	public int firstOccur(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (array[mid] < target) {
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
	
	public static void main(String[] args) {
		FirstOccurrence test = new FirstOccurrence();
		int[] array = {1,2,2,2,4,4};
		int target = 2;
		System.out.println(test.firstOccur(array, target));
	}
}
