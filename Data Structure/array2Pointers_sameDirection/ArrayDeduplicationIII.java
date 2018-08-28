package array2Pointers_sameDirection;

import impl.Utils;

/**
 * sorted array, duplicate element not retain any
 * {1,2,2,3,3,3} ¡ú {1}
 * Assumptions: array is not null
 */
public class ArrayDeduplicationIII {
	public int[] dedup(int[] array) {
		if (array.length <= 1) {
			return array;
		}
		// elements start from 0 and array[end] (exclusive) are kept.
		int end = 0;
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
		// copy the subarray to a new array
		int[] res = new int[end];
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
