package array2Pointers_sameDirection;

import impl.Utils;

/**
 * Sorted array, duplicate element only retain two:
 * Given a sorted integer array, remove duplicate elements. For each group of elements with the same value keep at most
 * two of them. Do this in-place, using the left side of the original array and maintain the relative order of the
 * elements of the array. Return the array after deduplication.
 * 
 * Assumptions:
 * The given array is not null
 * Examples:
 * {1, 2, 2, 3, 3, 3} -> {1, 2, 2, 3, 3}
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class ArrayDeduplicationII {
	public int[] dedup(int[] array) {
		if (array.length <= 2) {
			return array;
		}
		int end = 1; // elements start from 0 and array[end] (inclusive) are kept.
		for (int i = 2; i < array.length; i++) {
			if (array[end - 1] != array[i]) {
				end++;
				array[end] = array[i];
			}
		}
		int[] res = new int[end + 1]; // copy the subarray to a new array
		for (int i = 0; i <= end; i++) {
			res[i] = array[i];
		}
		return res;
	}
	
	public static void main(String[] args) {
		ArrayDeduplicationII test = new ArrayDeduplicationII();
		int[] array = {1,1,1,2,2,3,3};
		Utils.printArray(test.dedup(array));
	}
}
