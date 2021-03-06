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
 * 
 * Examples:
 * A = {3, 4, 1, 2, 5}, K = 3, the 3 smallest numbers are {1, 2, 3}
 * 
 * Time (quick select): average O(n), worst O(n^2)
 * Space: average O(logn), worst O(n)
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
	
	private void quickSelect(int[] arr, int l, int r, int k) { // process array from index l to r such that all elements between l and k - 1 < arr[k] and all elements between k + 1 and r > arr[k] (both inclusive)
		int pIdx = partition(arr, l, r); // now all elements from index l to pi - 1 < arr[pi] and all elements from index pi + 1 to r > arr[pi] (both inclusive)
		if (k > pIdx) { // if k > pi then index l to pi are ready (both inclusive) because they are < arr[k]
			quickSelect(arr, pIdx + 1, r, k); // in this case, still need to handle pi + 1 to r such that all elements between pi + 1 and k - 1 < arr[k] and all elements between k + 1 and r > arr[k] (both inclusive)
		} else if (k < pIdx) { // if k < pi then index pi to r are ready (both inclusive) because they are > arr[k]
			quickSelect(arr, l, pIdx - 1, k); // in this case, still need to handle l to pi - 1 such that all elements between l and k - 1 < arr[k] and all elements between k + 1 and pi - 1 > arr[k] (both inclusive)
		} else { // if k == pi, then it is done because all elements between l and k - 1 < arr[k] and all elements between k + 1 and r > arr[k] (both inclusive)
			return; 
		}
	}
	
	private int partition(int[] arr, int l, int r) {
		int pIdx = l + new Random().nextInt(r - l + 1); // pivot index
		int pivot = arr[pIdx];
		swap(arr, pIdx, r);
		pIdx = l;
		for (int i = l; i < r; i++) {
			if (arr[i] < pivot) {
				swap(arr, i, pIdx);
				pIdx++;
			}
		}
		swap(arr, pIdx, r);
		return pIdx;
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
