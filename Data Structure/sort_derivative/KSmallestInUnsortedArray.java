package sort_derivative;

import java.util.Arrays;
import java.util.Random;

import impl.Utils;

/**
 * Find the K smallest numbers in an unsorted integer array A. The returned numbers should be in ascending order.
 * 
 * Assumptions:
 * 1. A is not null
 * 2. K >= 0 and <= A.length
 * Examples:
 * A = {3, 4, 1, 2, 5}, K = 3, the 3 smallest numbers are {1, 2, 3}
 */
public class KSmallestInUnsortedArray {
	public int[] kSmallest(int[] array, int k) {
		if (array.length == 0 || k == 0) {
			return new int[0];
		}
		quickSelect(array, 0, array.length - 1, k - 1);
		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = array[i];
		}
		Arrays.sort(res);
		return res;
	}
	
	private void quickSelect(int[] array, int left, int right, int target) {
		int pIndex = partition(array, left, right);
		if (pIndex == target) {
			return;
		} else if (target < pIndex) {
			quickSelect(array, left, pIndex - 1, target);
		} else {
			quickSelect(array, pIndex + 1, right, target);
		}
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
	
	public static void main(String[] args) {
		KSmallestInUnsortedArray test = new KSmallestInUnsortedArray();
		int[] array = {3,4,1,2,5};
		int k = 3;
		Utils.printArray(test.kSmallest(array, k));
	}
}
