package array2Pointers_sameDirection;

import impl.Utils;

/**
 * Sorted array, duplicate element not retain any:
 * Given a sorted integer array, remove duplicate elements. For each group of elements with the same value do not keep
 * any of them. Do this in-place, using the left side of the original array and maintain the relative order of the
 * elements of the array. Return the array after deduplication.
 * 
 * Assumptions:
 * The given array is not null
 * 
 * Examples:
 * 1. {1, 2, 2, 3, 3, 3} -> {1}
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class ArrayDeduplicationIII {
	public int[] dedup(int[] array) {
		if (array.length <= 1) {
			return array;
		}
		int end = 0; // elements start from 0 and array[end] (exclusive) are kept.
		boolean repeat = false;
		for (int i = 1; i < array.length; i++) {
			if (array[i] == array[end]) {
				repeat = true;
			} else if (!repeat) {
				end++;
				array[end] = array[i];
			} else {
				array[end] = array[i];
				repeat = false;
			}
		}
		if (!repeat) {
			end++;
		}
		int[] res = new int[end]; // copy the subarray to a new array
		for (int i = 0; i < end; i++) {
			res[i] = array[i];
		}
		return res;
	}
	
	public static void main(String[] args) {
		ArrayDeduplicationIII test = new ArrayDeduplicationIII();
		int[] array = {1,1,1,2,2,3,3};
		Utils.printArray(test.dedup(array));
	}
}
