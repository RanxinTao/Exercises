package sort;

/**
 * Given an array of integers, sort the elements in the array in ascending order.
 * The selection sort algorithm should be used to solve this problem.
 * 
 * Examples:
 * {1} is sorted to {1}
 * {1, 2, 3} is sorted to {1, 2, 3}
 * {3, 2, 1} is sorted to {1, 2, 3}
 * {4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
 * 
 * Time: O(n^2), Space: O(1)
 */
public class SelectionSort {
	public int[] solve(int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}
		for (int i = 0; i < array.length - 1; i++) {
			int min_index = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[min_index] > array[j]) {
					min_index = j;
				}
			}
			swap(array, min_index, i);
		}
		return array;
	}

	private void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}
