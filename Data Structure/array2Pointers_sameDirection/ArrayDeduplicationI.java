package array2Pointers_sameDirection;

/**
 * sorted array, duplicate element only retain one
 * {1,2,2,3,3,3} ¡ú {1,2,3}
 * Assumptions: array is not null
 */
public class ArrayDeduplicationI {
	public int[] dedup(int[] array) {
		if (array.length <= 1) {
			return array;
		}
		// elements start from 0 and array[end] (inclusive) are kept.
		int end = 0; 
		for (int i = 1; i < array.length; i++) {
			if (array[end] != array[i]) {
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
}
