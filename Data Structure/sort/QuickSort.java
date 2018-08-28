package sort;

import java.util.Random;

public class QuickSort {
	public int[] quickSort(int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}
		quickSort(array, 0, array.length - 1);
		return array;
	}

	private void quickSort(int[] array, int left, int right) {
		if (left >= right) {
			return;
		}
		int pIndex = partition(array, left, right);
		quickSort(array, left, pIndex - 1);
		quickSort(array, pIndex + 1, right);
	}

	private int partition(int[] array, int left, int right) {
		int pIndex = left + new Random().nextInt(right - left + 1);
		int pivot = array[pIndex];
		swap(array, pIndex, right);
		pIndex = left;
		for (int i = left; i < right; i++) {
			if (array[i] < pivot) {
				swap(array, i, pIndex);
				pIndex++;
			}
		}
		swap(array, pIndex, right);
		return pIndex;
	}

	private void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}
