package sort;

import impl.Utils;

public class MergeSort_old {
	public int[] mergeSort(int[] array) {
		if (array.length <= 1) {
			return array;
		}
		int mid = array.length / 2;
		int[] left = new int[mid];
		int[] right = new int[array.length - mid];
		for (int i = 0; i < mid; i++) {
			left[i] = array[i];
		}
		for (int i = mid; i < array.length; i++) {
			right[i - mid] = array[i];
		}
		mergeSort(left);
		mergeSort(right);
		merge(left, right, array);
		return array;
	} 
	
	private void merge(int[] left, int [] right, int[] array) {
		int i = 0, j = 0, k = 0;
		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				array[k++] = left[i++];
			} else {
				array[k++] = right[j++];
			}
		}
		while (i < left.length) {
			array[k++] = left[i++];
		}
		while (j < right.length) {
			array[k++] = right[j++];
		}
	}
	
	public static void main(String[] args) {
		MergeSort_old test = new MergeSort_old();
		int[] array = {4,2,-3,6,1};
		Utils.printArray(test.mergeSort(array));
	}
}
