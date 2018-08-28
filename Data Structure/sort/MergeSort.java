package sort;

import impl.Utils;

public class MergeSort {
	public int[] mergeSort(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}
		mergeSort(array, 0, array.length - 1);
		return array;
	}
	
	public void mergeSort(int[] array, int left, int right) {
		if (left == right) {
			return;
		}
		int mid = left + (right - left) / 2;
		mergeSort(array, left, mid);
		mergeSort(array, mid + 1, right);
		merge(array, left, mid, right);
	} 
	
	private void merge(int[] array, int left, int mid, int right) {
		// copy the content to helper arrays
		int[] leftHalf = new int[mid - left  + 1];
		int[] rightHalf = new int[right - mid];
		int index = 0;
		for (int i = left; i <= mid; i++) {
			leftHalf[index++] = array[i];
		}
		index = 0;
		for (int i = mid + 1; i <= right; i++) {
			rightHalf[index++] = array[i];
		}
		// merge into the original array
		int i = 0, j = 0, k = left;
		while (i < leftHalf.length && j < rightHalf.length) {
			if (leftHalf[i] <= rightHalf[j]) {
				array[k++] = leftHalf[i++];
			} else {
				array[k++] = rightHalf[j++];
			}
		}
		while (i < leftHalf.length) {
			array[k++] = leftHalf[i++];
		}
		while (j < rightHalf.length) {
			array[k++] = rightHalf[j++];
		}
	}
	
	public static void main(String[] args) {
		MergeSort test = new MergeSort();
		int[] array = {4,2,-3,6,1};
		Utils.printArray(test.mergeSort(array));
	}
}
