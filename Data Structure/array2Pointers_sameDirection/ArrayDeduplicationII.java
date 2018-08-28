package array2Pointers_sameDirection;

import impl.Utils;

/**
 * sorted array, duplicate element only retain two
 * {1, 2, 2, 3, 3, 3} ¡ú {1, 2, 2, 3, 3}
 * Assumptions: array is not null
 */
public class ArrayDeduplicationII {
	public int[] dedup(int[] array) {
		if (array.length <= 2) {
			return array;
		}
		// elements start from 0 and array[end] (inclusive) are kept.
		int end = 1;
		for (int i = 2; i < array.length; i++) {
			if (array[end - 1] != array[i]) {
				end++;
				array[end] = array[i];
			}
		}
		// copy the subarray to a new array
		int[] res = new int[end + 1];
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
