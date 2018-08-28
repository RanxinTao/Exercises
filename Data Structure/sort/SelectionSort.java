package sort;

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
