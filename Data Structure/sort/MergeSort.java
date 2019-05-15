package sort;

import impl.Utils;

/**
 * Given an array of integers, sort the elements in the array in ascending order.
 * The merge sort algorithm should be used to solve this problem.
 * 
 * Examples:
 * {1} is sorted to {1}
 * {1, 2, 3} is sorted to {1, 2, 3}
 * {3, 2, 1} is sorted to {1, 2, 3}
 * {4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
 * 
 * Time: O(nlogn)
 * Space: O(n)
 */
public class MergeSort {
	public int[] mergeSort(int[] array) {
		if (array == null || array.length <= 1) {
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
		for (int i = 0, j = left; j <= mid; i++, j++) {
			leftHalf[i] = array[j];
		}
		int[] rightHalf = new int[right - mid];
		for (int i = 0, j = mid + 1; j <= right; i++, j++) {
			rightHalf[i] = array[j];
		}
		// merge into the original array
		int i = 0;
		int j = 0;
		while (i < leftHalf.length && j < rightHalf.length) {
			if (leftHalf[i] <= rightHalf[j]) {
				array[left++] = leftHalf[i++];
			} else {
				array[left++] = rightHalf[j++];
			}
		}
		while (i < leftHalf.length) {
			array[left++] = leftHalf[i++];
		}
		while (j < rightHalf.length) {
			array[left++] = rightHalf[j++];
		}
	}
	
	public static void main(String[] args) {
		MergeSort test = new MergeSort();
		int[] array = {4,2,-3,6,1};
		Utils.printArray(test.mergeSort(array));
	}
}
