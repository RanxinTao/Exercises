package sort_derivative;

import impl.Utils;

/**
 * Given an array A of length N containing all positive integers from [1...N]. How to get an array B such that B[i] 
 * represents how many elements A[j] (j > i) in array A that are smaller than A[i] (Count smaller elements on right side)
 * 
 * Requirement: time complexity = O(nlogn).
 * 
 * Assumptions:
 * 1. The given array A is not null.
 * 2. There could be duplicates in the array.
 * 
 * Examples:
 * 1. A = {4, 1, 3, 2}, we should get B = {3, 0, 1, 0}.
 * 
 * Time: O(nlogn)
 * Space: O(n)
 */
public class GetCountArray {
	public int[] countArray(int[] array) {
		int[] res = new int[array.length];
		if (array.length == 0) {
			return res;
		}
		Pair[] pairs = new Pair[array.length]; // order will be changed later during merge sort so must make a copy.
		Pair[] pairsCopy = new Pair[array.length];
		for (int i = 0; i < array.length; i++) {
			Pair pair = new Pair(array[i]);
			pairs[i] = pair;
			pairsCopy[i] = pair;
		}
		mergeSort(pairs, 0, array.length - 1);
		for (int i = 0; i < pairsCopy.length; i++) {
			res[i] = pairsCopy[i].res;
		}
		return res;
	}
	
	public void mergeSort(Pair[] array, int left, int right) {
		if (left == right) {
			return;
		}
		int mid = left + (right - left) / 2;
		mergeSort(array, left, mid);
		mergeSort(array, mid + 1, right);
		merge(array, left, mid, right);
	} 
	
	private void merge(Pair[] array, int left, int mid, int right) {
		Pair[] leftHalf = new Pair[mid - left  + 1];
		for (int i = 0, j = left; j <= mid; i++, j++) { // copy the left half to a helper array
			leftHalf[i] = array[j];
		}
		Pair[] rightHalf = new Pair[right - mid];
		for (int i = 0, j = mid + 1; j <= right; i++, j++) { // copy the right half to a helper array
			rightHalf[i] = array[j];
		}
		int i = 0;
		int j = 0;
		int count = 0;
		while (i < leftHalf.length && j < rightHalf.length) { // merge into the original array
			if (leftHalf[i].num <= rightHalf[j].num) {
				leftHalf[i].res += count;
				array[left++] = leftHalf[i++];
			} else { // leftHalf[i] > rightHalf[j]
				count++;
				array[left++] = rightHalf[j++];
			}
		}
		while (i < leftHalf.length) {
			leftHalf[i].res += count;
			array[left++] = leftHalf[i++];
		}
		while (j < rightHalf.length) {
			array[left++] = rightHalf[j++];
		}
	}
	
	static class Pair {
		int num;
		int res;
		
		public Pair(int num) {
			this.num = num;
			res = 0;
		}
	}
	
	public static void main(String[] args) {
		GetCountArray test = new GetCountArray();
		int[] array = {4, 1, 6, 6, 2, 5, 3};
		int[] res = test.countArray(array);
		Utils.printArray(res);
	}
}
